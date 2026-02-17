package com.jeferro.architecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import jakarta.persistence.Entity;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class ModularDataUnitTest {

  private static final String BASE_PACKAGE = "com.jeferro";

  private static final String TABLE_ANNOTATION = "jakarta.persistence.Table";

  private static final ArchCondition<JavaClass> entityClassesHaveTableWithSchemaMatchingModule = new ArchCondition<>(
          "have @Table annotation with schema attribute matching the module name") {

    @Override
    public void check(JavaClass javaClass, ConditionEvents events) {
      String moduleName = extractModuleName(javaClass);

      if (moduleName == null) {
        return;
      }

      var tableAnnotation = javaClass.tryGetAnnotationOfType(TABLE_ANNOTATION);
      if (tableAnnotation.isEmpty()) {
        var message = String.format("Class %s is annotated with @Entity but lacks @Table annotation",
                javaClass.getFullName());
        events.add(SimpleConditionEvent.violated(javaClass, message));
        return;
      }

      String schema = tableAnnotation.get().get("schema")
              .map(Object::toString)
              .orElse("");

      if (!schema.equals(moduleName)) {
        var message = String.format("Class %s has @Table(schema = \"%s\") but should have schema = \"%s\" (module name)",
                javaClass.getFullName(), schema, moduleName);
        events.add(SimpleConditionEvent.violated(javaClass, message));
      }
    }
  };

  @Test
  void entity_classes_must_have_table_annotation_with_schema_matching_module() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);

    ArchRule rule = classes().that().areAnnotatedWith(Entity.class)
            .and().resideInAPackage(BASE_PACKAGE + "..")
            .should(entityClassesHaveTableWithSchemaMatchingModule);

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
}
