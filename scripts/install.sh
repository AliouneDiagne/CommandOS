#!/bin/bash
echo "--- CommandOS Installation Script ---"

# Check Java
if type -p java; then _java=java
elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]]; then _java="$JAVA_HOME/bin/java"
else echo "Java 17+ required."; exit 1
fi

JAVA_VERSION=$("$_java" -version 2>&1 | awk -F\" '/version/ {print $2}')
if [[ "$JAVA_VERSION" < "17" ]]; then echo "Java $JAVA_VERSION too old."; exit 1; fi

# Gradle Wrapper
if [ ! -f "gradlew" ]; then
    echo "Gradle wrapper not found. Generating..."
    command -v gradle >/dev/null || { echo "Install Gradle."; exit 1; }
    gradle wrapper --gradle-version 8.4.1 || { echo "Wrapper failed."; exit 1; }
    echo "Wrapper created."
fi

chmod +x gradlew
./gradlew clean build shadowJar || { echo "Build failed."; exit 1; }

mkdir -p "$HOME/.commandos" data plugins
echo "--- Installation complete ---"
