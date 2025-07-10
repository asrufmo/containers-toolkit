# Containers Toolkit

Reusable Java toolkit for managing Docker containers using Testcontainers in integration and black-box tests.

## 🔧 Features

- Interface-based design: `ContainerManager`, `ContainerProvider`
- Supports databases like PostgreSQL out of the box
- Clean separation of orchestration and lifecycle
- Easily extendable to Kafka, Redis, or cloud emulators

## 📦 Installation

```bash
mvn clean install
```

## 🧪 How to Use

Add the dependency to your consumer project's `pom.xml`:

```xml
<dependency>
  <groupId>com.testing</groupId>
  <artifactId>containers-toolkit</artifactId>
  <version>1.0-SNAPSHOT</version>
  <scope>test</scope>
</dependency>
```

Then register and start containers inside your integration test:

```java
ContainerOrchestrator orchestrator = new ContainerOrchestrator();
orchestrator.register(new DatabaseContainerManager(List.of(new PostgresContainerProvider())));
orchestrator.startAll();
```

## 🧱 Package Structure

```
com.testing.containers
├── core
│   ├── ContainerOrchestrator.java
│   ├── interfaces/
├── managers/
├── providers/
└── utils/
```

## 📄 License

MIT