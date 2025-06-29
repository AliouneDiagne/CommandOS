@echo off
echo --- CommandOS Installation Script ---

java -version > NUL 2>&1 || (echo Java 17+ required. & goto :eof)

FOR /f "tokens=* delims=" %%i IN ('java -version 2^>^&1 ^| findstr /i "version"') DO (
  FOR /f "tokens=2 delims=." %%j IN ("%%i") DO SET JAVA_MAJOR_VERSION=%%j
)
IF %JAVA_MAJOR_VERSION% LSS 17 (
  echo Java %JAVA_MAJOR_VERSION% too old.
  goto :eof
)

IF NOT EXIST gradlew.bat (
  echo Generating Gradle Wrapper...
  where /Q gradle || (echo Gradle not found. & goto :eof)
  gradle wrapper --gradle-version 8.4.1 || goto :eof
)

call gradlew.bat clean build shadowJar || goto :eof

mkdir "%USERPROFILE%\.commandos" > NUL 2>&1
mkdir data > NUL 2>&1
mkdir plugins > NUL 2>&1

echo --- Installation complete ---
