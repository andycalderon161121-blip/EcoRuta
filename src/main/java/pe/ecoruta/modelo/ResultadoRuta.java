package pe.ecoruta.modelo;

public class ResultadoRuta {
    private final String nombre;
    private final int minutos;
    private final double costo;
    private final int incidencias;

    public ResultadoRuta(String nombre, int minutos, double costo, int incidencias) {
        this.nombre = nombre;
        this.minutos = minutos;
        this.costo = costo;
        this.incidencias = incidencias;
    }

    public String getNombre() { return nombre; }
    public int getMinutos() { return minutos; }
    public double getCosto() { return costo; }
    public int getIncidencias() { return incidencias; }
}
