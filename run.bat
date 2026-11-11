@echo off
echo Abriendo EcoRuta Piura...
if not exist out mkdir out
javac -encoding UTF-8 -d out src\main\java\pe\ecoruta\modelo\ResultadoRuta.java src\main\java\pe\ecoruta\strategy\RutaStrategy.java src\main\java\pe\ecoruta\strategy\RutaRapida.java src\main\java\pe\ecoruta\strategy\RutaEconomica.java src\main\java\pe\ecoruta\strategy\RutaSegura.java src\main\java\pe\ecoruta\servicio\Planificador.java src\main\java\pe\ecoruta\vista\VentanaPrincipal.java src\main\java\pe\ecoruta\Main.java
if errorlevel 1 (
  echo.
  echo No se pudo compilar. Verifica que tengas JDK 17 o superior.
  pause
  exit /b 1
)
java -cp out pe.ecoruta.Main
