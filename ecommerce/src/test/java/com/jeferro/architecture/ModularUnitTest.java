package com.jeferro.architecture;

import com.tngtech.archunit.core.domain.Dependency;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class ModularUnitTest {

  private static final String BASE_PACKAGE = "com.jeferro";

  private static final ArchCondition<JavaClass> onlyDependOnModularContractsFromOtherModules = new ArchCondition<>(
          "only depend on classes within modular_contracts package of other modules") {

    @Override
    public void check(JavaClass sourceClass, ConditionEvents events) {
      String sourceModule = extractModuleName(sourceClass);

      Set<JavaClass> violations = sourceClass.getDirectDependenciesFromSelf().stream()
              .map(Dependency::getTargetClass)
              .filter(target -> isCrossModuleDependency(sourceModule, target))
              .filter(target -> !isInModuleContractsPackage(target))
              .collect(Collectors.toSet());

      for (JavaClass violation : violations) {
        var message = String.format("Class %s must not depend on %s. Cross-module dependencies may only target " +
                        "classes in the modular_contracts package",
                sourceClass.getFullName(), violation.getFullName());
        var event = SimpleConditionEvent.violated(sourceClass, message);
        events.add(event);
      }
    }
  };

  private static final ArchCondition<JavaClass> crossModuleDependenciesOnlyInInfrastructure = new ArchCondition<>(
          "only have cross-module dependencies when in infrastructure layer") {

    @Override
    public void check(JavaClass sourceClass, ConditionEvents events) {
      String sourceModule = extractModuleName(sourceClass);

      boolean hasCrossModuleDependency = sourceClass.getDirectDependenciesFromSelf().stream()
              .map(Dependency::getTargetClass)
              .anyMatch(target -> isCrossModuleDependency(sourceModule, target));

      if (hasCrossModuleDependency && !isInInfrastructureLayer(sourceClass)) {
        var message = String.format("Class %s has cross-module dependencies but is not in the infrastructure layer. " +
                        "Cross-module dependencies may only exist in infrastructure",
                sourceClass.getFullName());
        var event = SimpleConditionEvent.violated(sourceClass, message);
        events.add(event);
      }
    }
  };

  @Test
  void module_can_only_depend_on_modular_contracts_from_other_modules() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);

    ArchRule rule = classes().that().resideInAPackage(BASE_PACKAGE + "..")
            .should(onlyDependOnModularContractsFromOtherModules);

    rule.check(importedClasses);
  }

  @Test
  void cross_module_dependencies_only_in_infrastructure_layer() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);

    ArchRule rule = classes().that().resideInAPackage(BASE_PACKAGE + "..")
            .should(crossModuleDependenciesOnlyInInfrastructure);

    rule.check(importedClasses);
  }

  private static String extractModuleName(JavaClass javaClass) {
    String packageName = javaClass.getPackageName();
    if (!packageName.startsWith(BASE_PACKAGE + ".")) {
      return null;
    }
    String afterBase = packageName.substring(BASE_PACKAGE.length() + 1);
    return afterBase.split("\\.")[0];
  }

  private static boolean isCrossModuleDependency(String sourceModule, JavaClass target) {
    if (!target.getPackageName().startsWith(BASE_PACKAGE + ".")) {
      return false;
    }

    String targetModule = extractModuleName(target);
    return targetModule != null && !targetModule.equals(sourceModule);
  }

  private static boolean isInModuleContractsPackage(JavaClass target) {
    String packageName = target.getPackageName();

    return packageName.contains(".module_contracts");
  }

  private static boolean isInInfrastructureLayer(JavaClass javaClass) {
    return javaClass.getPackageName().contains(".infrastructure.");
  }
}
