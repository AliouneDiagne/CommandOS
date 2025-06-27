# CommandOS - Technical Architecture Document

---

## 1. Introduction

**CommandOS** is a pure Java SE 17+ Command Line Interface (CLI) operating system simulator.  
It demonstrates advanced Java programming, OOP, design patterns, and secure coding in practice.

---

## 2. Objectives and Scope

| **Aspect**    | **Details**                                                                           |
|---------------|---------------------------------------------------------------------------------------|
| Platform      | Java SE 17+ (no external GUI dependencies)                                            |
| Functionality | User authentication, virtual filesystem, extensible UNIX-like commands, macro, plugins|
| Principles    | Modular, extensible, testable, secure (security by design), Open/Closed Principle     |

---

## 3. Modular Architecture

CommandOS uses a **modular package structure** for maintainability and clarity:

| **Package**             | **Responsibility / Key Classes**                                                      |
|-------------------------|---------------------------------------------------------------------------------------|
| `core`                  | `Command`, `CommandFactory`, `CompositeCommand`, `HistoryIterator`                   |
| `commands`              | `CopyCommand`, `MoveCommand`, `HelpCommand`, `InvalidCommand`, `UnknownCommand`      |
| `fs`                    | `FsNode`, `FileLeaf`, `DirComposite` (Composite pattern)                             |
| `infra`                 | `SingletonLogger` (Singleton), `SafeRunner` (Exception Shielding), `InputSanitizer`  |
| `plugin`                | `Plugin` (interface), `PluginLoader` (SPI, Adapter)                                  |
| `proc`                  | `ProcessManager` (multithreading)                                                    |
| `security`              | `AuthService`, `Config` (YAML/properties loader)                                     |
| `strategy`              | `ExecutionStrategy`, `SyncStrategy`, `AsyncStrategy`                                 |
| `ui`                    | `Shell`, `ShellLauncher` (CLI)                                                       |

---

## 4. Key Design Patterns

- **Factory Method:** `CommandFactory.build()` centralizes command creation (Open/Closed Principle).
- **Composite:** Both filesystem and macro commands support uniform object/composition handling.
- **Iterator:** `HistoryIterator` offers safe, immutable command history traversal.
- **Exception Shielding:** `SafeRunner` ensures no crash, generic error for user, logs details.
- **Command Pattern:** All actions are polymorphic (`Command` interface).
- **Builder (optional):** Macro construction via `CompositeCommand` builder.
- **Strategy (optional):** `ExecutionStrategy` for sync/async command execution.
- **Singleton:** `SingletonLogger` as global logger.
- **Adapter:** `PluginLoader` bridges external plugins to core.

---

## 5. Security by Design

- **Input Sanitization:** All input via `InputSanitizer` (whitelist regex).
- **No Hardcoded Secrets:** Users/passwords/config from external YAML (never in code).
- **Exception Handling:** No stack traces to user, only secure log (internal).
- **Secure Logging:** No sensitive data in logs, with rotation and proper levels.

---

## 6. Technologies & Tools

| **Technology**    | **Use**                                 |
|-------------------|------------------------------------------|
| Java SE 17+       | Core platform                            |
| Gradle (wrapper)  | Build, test, fat-JAR                     |
| JUnit 5 & Mockito | Testing, code coverage                   |
| Java Collections  | Data structures (commands, history, etc) |
| Java NIO2         | Filesystem and CLI I/O                   |
| Reflection & SPI  | Dynamic plugin loading                   |
| Stream & Lambdas  | Functional data handling                 |
| Multithreading    | Async/process simulation                 |
| PlantUML          | UML diagrams                             |
| Docker, GraalVM   | Container and native-image deployment    |
| GitHub Actions    | CI/CD pipeline                           |

---

## 7. Installation & Setup

> See **README.md** for step-by-step build and run instructions.

---

## 8. Conclusion

**CommandOS** is a reference Java SE project:
- Clean OOP & modular design
- Secure, robust, and extensible architecture
- Ready for academic and professional use

---

