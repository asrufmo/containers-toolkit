# 🧰 Containers Toolkit

**Reusable Java toolkit for orchestrating Docker containers in integration and black-box tests using [Testcontainers](https://www.testcontainers.org/).**

---

## 🚀 Features

- ✅ Interface-driven architecture (`ContainerManager`, `ContainerProvider`)
- 🐘 Out-of-the-box PostgreSQL support
- 🚀 Spring Boot container manager with health check support
- 🔌 Clean separation between orchestration and container lifecycle
- 🔧 Easily extendable to Redis, Kafka, or cloud service emulators

---

## 📦 Installation

Build and install locally:

```bash
mvn clean install


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
│   └── interfaces/
├── managers/
│   ├── DatabaseContainerManager.java
│   └── SpringBootContainerManager.java
├── providers/
│   └── PostgresContainerProvider.java
└── utils/

```
## 🔧 Supported Containers

```
Container Type	 Provider Class	            Notes
PostgreSQL	     PostgresContainerProvider	Ready with alias + wait
Spring Boot	     SpringBootContainerManager	Supports health checks

```

## 📄 License

MIT