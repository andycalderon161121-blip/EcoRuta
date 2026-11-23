# EcoRuta Piura

Planificador de entregas que permite elegir entre una ruta **rápida**, **económica** o **segura**, aplicando el patrón de diseño **Strategy**.

Proyecto final del curso **Diseño de Patrones (100000SI47)** — UTP, 2026 Ciclo 2 Agosto.

## Integrantes

| Nombre | Código | Usuario de GitHub |
|---|---|---|
| _Nombre completo_ | _código_ | andycalderon161121-blip |
| _Nombre completo_ | _código_ | _usuario_ |
| _Nombre completo_ | _código_ | _usuario_ |

## Problema que resuelve

Quien hace entregas en Piura no siempre prioriza lo mismo: a veces necesita llegar en el menor tiempo, otras veces gastar lo mínimo o evitar incidencias en el recorrido. Sin una estructura adecuada, cada criterio nuevo obliga a modificar la clase que planifica la ruta.

EcoRuta Piura permite elegir qué priorizar y muestra, para cada criterio, el tiempo estimado, el costo y las incidencias, de modo que el usuario compara y decide.

## Patrón aplicado: Strategy

| Campo | Detalle |
|---|---|
| Nombre | Strategy |
| Clasificación | De comportamiento (GoF) |
| Problema | Existen varias formas de calcular una ruta y el usuario debe poder cambiarla en tiempo de ejecución sin modificar la clase que la usa. |
| Solución aplicada | Cada criterio es una clase que implementa una interfaz común. `Planificador` trabaja con la interfaz, no con una estrategia concreta. |

### Clases participantes

| Rol en el patrón | Clase | Responsabilidad |
|---|---|---|
| Strategy | `RutaStrategy` (interfaz) | Define `calcularRuta()`, `getNombre()` y `getDescripcion()`. |
| ConcreteStrategy | `RutaRapida` | Prioriza el menor tiempo. |
| ConcreteStrategy | `RutaEconomica` | Prioriza el menor costo. |
| ConcreteStrategy | `RutaSegura` | Prioriza la menor cantidad de incidencias. |
| Context | `Planificador` | Guarda la estrategia elegida y delega en ella (`planificar()`). |
| Cliente | `VentanaPrincipal` | Interfaz Swing; crea la estrategia según la opción elegida y la asigna al contexto. |

### Consecuencias

**Ventajas**
- Agregar un nuevo criterio (por ejemplo, ruta ecológica) solo requiere una clase nueva, sin tocar `Planificador` (principio Abierto/Cerrado).
- Elimina condicionales `if/else` o `switch` dentro de la lógica de planificación.
- Cada algoritmo vive en su propia clase (Responsabilidad Única) y se puede probar por separado.
- La estrategia se cambia en tiempo de ejecución.

**Desventajas**
- Aumenta el número de clases.
- El cliente debe conocer las estrategias disponibles para elegir una.

### Comparación antes / después

**Sin el patrón:** toda la lógica queda en una sola clase y crece con cada criterio nuevo.

```java
public class Planificador {
    public ResultadoRuta planificar(String tipo) {
        if (tipo.equals("rapida")) {
            return new ResultadoRuta("Ruta rápida", 18, 8.50, 2);
        } else if (tipo.equals("economica")) {
            return new ResultadoRuta("Ruta económica", 29, 3.00, 3);
        } else if (tipo.equals("segura")) {
            return new ResultadoRuta("Ruta segura", 24, 5.50, 0);
        }
        return null; // cada criterio nuevo obliga a editar esta clase
    }
}
```

**Con Strategy:** `Planificador` delega y no cambia al agregar criterios.

```java
public class Planificador {
    private RutaStrategy estrategia;

    public Planificador(RutaStrategy estrategia) { this.estrategia = estrategia; }
    public void setEstrategia(RutaStrategy estrategia) { this.estrategia = estrategia; }

    public ResultadoRuta planificar() {
        return estrategia.calcularRuta(); // no conoce ninguna ruta concreta
    }
}
```

## Principios SOLID aplicados

- **S (Responsabilidad Única):** cada estrategia calcula un solo tipo de ruta; `Planificador` solo coordina; `VentanaPrincipal` solo muestra.
- **O (Abierto/Cerrado):** se agregan estrategias nuevas sin modificar `Planificador`.
- **D (Inversión de Dependencias):** `Planificador` depende de la interfaz `RutaStrategy`, no de clases concretas.

## Diagrama de clases

![Diagrama de clases](docs/diagrama-clases.png)

## Estructura del proyecto

```
├── README.md
├── .gitignore
├── pom.xml
├── run.bat
├── docs/
│   ├── diagrama-clases.png
│   └── presentacion.pdf
└── src/main/java/pe/ecoruta/
    ├── Main.java
    ├── modelo/ResultadoRuta.java
    ├── servicio/Planificador.java
    ├── strategy/
    │   ├── RutaStrategy.java
    │   ├── RutaRapida.java
    │   ├── RutaEconomica.java
    │   └── RutaSegura.java
    └── vista/VentanaPrincipal.java
```

## Cómo compilar y ejecutar

**Requisito:** JDK 17 o superior.

```bash
git clone https://github.com/andycalderon161121-blip/ProyectoPatrones1
cd ProyectoPatrones1
```

**Windows:** ejecutar `run.bat`.

**Cualquier sistema (terminal):**

```bash
mkdir out
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out pe.ecoruta.Main
```

**Desde un IDE (NetBeans, IntelliJ, VS Code):** abrir la carpeta del proyecto, abrir `Main.java` y ejecutarlo.

## Capturas de pantalla

| Ruta rápida | Ruta económica | Ruta segura |
|---|---|---|
| ![Rápida](docs/captura-rapida.png) | ![Económica](docs/captura-economica.png) | ![Segura](docs/captura-segura.png) |
