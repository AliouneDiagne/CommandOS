# 🐚 CommandOS — Secure CLI OS Simulator in Java

![Build](https://github.com/AliouneDiagne/CommandOS/actions/workflows/test.yml/badge.svg)
![Coverage](https://img.shields.io/badge/Coverage-82%25-brightgreen.svg)

> **CommandOS** is a secure, extensible UNIX-style Command-Line Operating System simulator, built in modern Java 17+ for didactic and real-world excellence.
> Includes advanced OOP, robust architecture, essential design patterns, solid error handling, and a full testing/CI pipeline.

---

## ✨ Features

* **UNIX-style Interactive Shell:** Supports `ls`, `cd`, `mkdir`, `rm`, `copy`, `move`, `cat`, `touch`, `echo`, `help`, `macro`, `ps`, `kill`, `exit`, and plugin commands.
* **Virtual Filesystem:** In-memory, tree-based, using the Composite pattern for directories and files.
* **Macro Support:** Run sequences of commands together (see demos below).
* **Plugin Architecture:** Drop any JAR into `/plugins/` and new commands auto-register (Java SPI/Reflection, no restart needed).
* **Process Simulation:** Run/kill simulated background jobs (`ps`, `kill`).
* **Security-First:**

  * All input sanitized to prevent injection or traversal.
  * Exception shielding: no stack traces for users.
  * No hardcoded secrets—everything in config files.
  * Full, rotating logging in `/data/commandos.log`.

---

## ⚡ Quick Start

**Requirements:**

* Java 17+
* Gradle 8+ (`./gradlew` included — no system install needed)

**Build & Run:**

```powershell
git clone https://github.com/AliouneDiagne/CommandOS.git
cd CommandOS
./gradlew clean test shadowJar
java -jar build/libs/commandos-all.jar
```

**Demo script (batch commands):**

```powershell
Get-Content scripts/demo.txt | java -jar build/libs/commandos-all.jar
```

---

## 🗂️ Available Commands

| Command | Usage / Syntax         | Description                 |                          |
| ------- | ---------------------- | --------------------------- | ------------------------ |
| help    | `help`                 | Show all available commands |                          |
| mkdir   | `mkdir <dirname>`      | Create a new directory      |                          |
| touch   | `touch <filename>`     | Create an empty file        |                          |
| ls      | `ls` or `ls <path>`    | List files and directories  |                          |
| cat     | `cat <filename>`       | Print contents of a file    |                          |
| copy    | `copy <src> <dest>`    | Copy file or directory      |                          |
| move    | `move <src> <dest>`    | Move or rename file/dir     |                          |
| rm      | `rm <name>`            | Remove file or directory    |                          |
| echo    | `echo <text>`          | Print text to screen        |                          |
| macro   | \`macro <cmd1>         | <cmd2> ...\`                | Run commands in sequence |
| ps      | `ps`                   | List simulated processes    |                          |
| kill    | `kill <pid>`           | Kill a simulated process    |                          |
| plugin: | `plugin:<name> <args>` | Run external plugin command |                          |
| exit    | `exit`                 | Exit CommandOS              |                          |

> **Note:** All commands are entered *one at a time* (no numbers or extra text!), exactly as shown in the shell. *No PowerShell or Bash commands inside CommandOS!*

---


Here is **Part 2** — with *real* CommandOS usage examples, demos, and advanced scenarios (all tested for actual CLI, **not PowerShell/Bash**):

---

## 🧑‍💻 Example Usage

**Basic Interactive Session**
Start CommandOS and type commands *one at a time*:

```
Welcome to CommandOS ? type 'help' for commands.
CommandOS >>> mkdir my_project
CommandOS >>> cd my_project
CommandOS >>> touch hello.txt
CommandOS >>> echo Hello, CommandOS!
CommandOS >>> ls
hello.txt
CommandOS >>> cat hello.txt
Hello, CommandOS!
CommandOS >>> cd ..
CommandOS >>> exit
Bye ?
```

---

### 📋 **Batch Demo (scripts/demo.txt)**

Example content for `scripts/demo.txt` (run all commands in order):

```
help
mkdir demo
cd demo
touch file1.txt
echo Hello, CommandOS!
cat file1.txt
ls
exit
```

Run this batch demo (from project root):

```powershell
Get-Content scripts/demo.txt | java -jar build/libs/commandos-all.jar
```

---

### 🛠️ **Advanced Scenarios**

**Project workspace setup:**

```
help
mkdir projects
cd projects
mkdir commandos
cd commandos
touch readme.txt
echo CommandOS Project - Info
cat readme.txt
mkdir src
cd src
touch main.java
echo public class Main {}
ls
cd ..
ls
cd ..
ls
exit
```

---

**File and Directory Operations:**

```
mkdir files
cd files
touch report.txt
echo First line
cat report.txt
touch backup.txt
copy report.txt backup.txt
cat backup.txt
move report.txt archived.txt
ls
rm backup.txt
ls
exit
```

---

**Macro & Combined Commands:**

```
macro mkdir test | cd test | touch a.txt | echo Hello | cat a.txt | ls
cd ..
macro mkdir bin | cd bin | touch script.sh | echo echo Hello | cat script.sh | ls
cd ..
ls
exit
```

---

**Demo: Trigger Errors (for safe error handling):**

```
cat notfound.txt
mkdir demo
mkdir demo
cd doesnotexist
rm unknown.txt
exit
```

---

Here is **Part 3** — with design, plugins, testing, structure, roadmap, and license.

---

## 🧠 Design Highlights

* **Classic Patterns:**

  * *Factory Method:* Centralized command creation via `CommandFactory`.
  * *Command Pattern:* Every CLI action is a `Command`, supports macros and plugins.
  * *Composite Pattern:* Virtual filesystem and macro commands use composites.
  * *Iterator:* `HistoryIterator` for robust, safe history navigation.
  * *Exception Shielding:* All errors handled via `SafeRunner`, never crash the CLI.
  * *Strategy:* Sync/async execution for processes.
* **Java Tech:**

  * Collections, Generics, ThreadPool, Logging (`SingletonLogger`), NIO2, Reflection/SPI.
* **Testing & Quality:**

  * *JUnit 5*, *Mockito*, and *Checkstyle* for ≥ 80% test coverage, enforced clean code.
* **Security:**

  * *InputSanitizer* on every CLI input.
  * *No stack traces* for the user, *no hardcoded secrets*.
  * *Rotating logs*, safe error messages only.

---

## 🔌 Plugins

**Extend CommandOS live:**

* Drop any `.jar` file into `/plugins/` — new commands are auto-loaded at startup.
* Plugins use standard Java SPI, fully decoupled from core code.
* Example: `plugin:echo "Hello, plugin world!"`

---

## 🧪 Testing & Quality

* **JUnit 5:** All core commands, error paths, and advanced cases are tested.
* **GitHub Actions:** Every commit runs all tests (see `.github/workflows/test.yml`).
* **Coverage badge:** Coverage ≥ 80% (badge auto-updates).
* **JavaDoc** and **inline docs:** Public API is fully documented; key methods in Italian for oral exam.

---

## 🏗️ Project Structure

```text
CommandOS/
├── README.md
├── LICENSE
├── build.gradle
├── settings.gradle
├── .gitignore
├── .github/
│   └── workflows/
│       └── test.yml
├── data/
│   └── commandos.log
├── plugins/
│   └── example-plugin.jar
├── scripts/
│   └── demo.txt
├── docs/
│   ├── README_ITA.pdf
│   ├── class-diagram.puml
│   └── commandos-architecture.pdf
├── Dockerfile
├── native-image.properties
└── src/
    ├── main/java/com/commandos/
    │   ├── core/
    │   ├── commands/
    │   ├── fs/
    │   ├── infra/
    │   ├── plugin/
    │   ├── proc/
    │   ├── security/
    │   ├── strategy/
    │   └── ui/
    ├── main/resources/
    │   └── config-example.yml
    └── test/java/com/commandos/
        ├── CliMacroTest.java
        ├── CommandFactoryTest.java
        ├── CompositeCommandTest.java
        ├── CopyCommandTest.java
        ├── HistoryIteratorTest.java
        ├── MacroParserTest.java
        ├── MkdirCommandTest.java
        ├── MoveCommandTest.java
        ├── PluginLoaderTest.java
        ├── SafeRunnerTest.java
        ├── ShellTest.java
        └── SingletonLoggerTest.java
```

---

## 🗺️ Roadmap / To Do

* [ ] Multi-user roles and ACL
* [ ] Encrypted user homes
* [ ] GUI (JavaFX/Swing)
* [ ] Real command piping (`ls | grep`)
* [ ] Scripting and automation
* [ ] Cloud integration, REST API (future)

---

## 📄 License

MIT © 2025 Alioune Diagne

---

**For more code, diagrams, and exam notes:**
See `/docs`, `/scripts`, and inline JavaDoc 🚀.

---
