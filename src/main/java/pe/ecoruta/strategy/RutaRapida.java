package pe.ecoruta.strategy;

import pe.ecoruta.modelo.ResultadoRuta;

public class RutaRapida implements RutaStrategy {
    @Override
    public ResultadoRuta calcularRuta() {
        return new ResultadoRuta("Ruta rápida", 18, 8.50, 2);
    }

    @Override
    public String getNombre() { return "Rápida"; }

    @Override
    public String getDescripcion() { return "Prioriza llegar en el menor tiempo."; }
}
