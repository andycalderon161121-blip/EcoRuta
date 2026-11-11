package pe.ecoruta.strategy;

import pe.ecoruta.modelo.ResultadoRuta;

public class RutaSegura implements RutaStrategy {
    @Override
    public ResultadoRuta calcularRuta() {
        return new ResultadoRuta("Ruta segura", 24, 5.50, 0);
    }

    @Override
    public String getNombre() { return "Segura"; }

    @Override
    public String getDescripcion() { return "Prioriza reducir las incidencias del recorrido."; }
}
