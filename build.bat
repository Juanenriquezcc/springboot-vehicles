@echo off
echo Building Vehicle API Spring Boot Application...
echo.

REM Check if Maven is installed
where mvn >nul 2>nul
if %errorlevel% neq 0 (
    echo ❌ Maven no está instalado o no está en el PATH del sistema
    echo Por favor, instale Maven y asegúrese de que esté en el PATH del sistema
    echo Visite: https://maven.apache.org/install.html
    exit /b 1
)

echo ✅ Maven encontrado
echo.
echo Compilando el proyecto...
echo.

REM Clean and compile the project
call mvn clean compile

if %errorlevel% equ 0 (
    echo.
    echo ✅ Compilación exitosa!
    echo.
    echo Para ejecutar la aplicación, use:
    echo mvn spring-boot:run
    echo.
    echo O cree el JAR ejecutable con:
    echo mvn clean package
    echo java -jar target/vehicle-api-1.0.0.jar
) else (
    echo.
    echo ❌ Error en la compilación
    echo Por favor, revise los mensajes de error anteriores
)

echo.
pause