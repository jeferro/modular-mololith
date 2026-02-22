# E-commerce Modular Monolith

Quarkus project with modular architecture for an e-commerce application. Contains three domain packages: products, clients, and invoices.

## Requirements

- [ASDF](https://asdf-vm.com/)
- [TASK](https://taskfile.dev/)
- [Bruno](https://www.usebruno.com/)

## Configure application in local

Install tools:

```bash
task install
```

Execute containers:

```bash
task env-up
```

## Run tests

```bash
task test-ecommerce
```

## Start the application

```bash
task start-ecommerce
```

There is a Bruno collection in directory bruno with all requests of application.