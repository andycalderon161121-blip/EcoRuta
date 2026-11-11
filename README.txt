ECORUTA PIURA - PATRON STRATEGY
================================

REQUISITOS
- Apache NetBeans
- JDK 17 o superior

ABRIR EN NETBEANS
1. Descomprime EcoRutaStrategy.zip.
2. Abre NetBeans.
3. Ve a File > Open Project.
4. Selecciona la carpeta EcoRutaStrategy (la que contiene pom.xml).
5. Espera que NetBeans cargue el proyecto.
6. Abre Source Packages > pe.ecoruta > Main.java.
7. Clic derecho en Main.java > Run File, o ejecuta el proyecto.

TAMBIEN PUEDES EJECUTARLO
- En NetBeans: clic derecho al proyecto > Run.
- Si tienes Maven instalado: mvn clean compile exec:java
  (si no tienes el plugin exec, ejecuta Main.java desde NetBeans).

¿QUE HACE?
Permite comparar tres formas de planificar una entrega ficticia:
- Rapida: prioriza el menor tiempo.
- Economica: prioriza el menor costo.
- Segura: prioriza la menor cantidad de incidencias.

¿DONDE ESTA STRATEGY?
1. RutaStrategy.java: interfaz común.
2. RutaRapida.java, RutaEconomica.java y RutaSegura.java: estrategias concretas.
3. Planificador.java: recibe y ejecuta la estrategia elegida.
4. VentanaPrincipal.java: interfaz JFrame; el usuario cambia la estrategia.

GUIA RAPIDA PARA EXPLICAR
"Strategy permite cambiar el algoritmo sin modificar la clase que lo utiliza.
En esta aplicación, el usuario elige si quiere una ruta rápida, económica o segura.
Todas cumplen la misma interfaz RutaStrategy, pero cada una calcula el resultado
con una prioridad diferente. Planificador trabaja con la interfaz, no depende de
una estrategia específica."

PARA UNA REVISION O CAMBIO RAPIDO EN CLASE
- Si no cambia el resultado al elegir otra opción: revisa el método cambiarEstrategia()
  de VentanaPrincipal.java y la asignación de estrategia en Planificador.java.
- Si aparece un error de compilación en una estrategia: revisa que tenga el método
  calcularRuta() y que use exactamente la firma de RutaStrategy.
- Si el botón no responde: revisa el ActionListener del botón btnCalcular en
  VentanaPrincipal.java.
- Si los resultados se ven vacíos: revisa mostrarResultado() en VentanaPrincipal.java.

No hay errores intencionales: el proyecto se entrega funcionando. Practiquen
identificar la interfaz, las estrategias concretas y el contexto.
