package pe.ecoruta.strategy;

import pe.ecoruta.modelo.ResultadoRuta;

public class RutaEconomica implements RutaStrategy {
    @Override
    public ResultadoRuta calcularRuta() {
        return new ResultadoRuta("Ruta económica", 29, 3.00, 3);
    }

    @Override
    public String getNombre() { return "Económica"; }

    @Override
    public String getDescripcion() { return "Prioriza gastar lo menos posible."; }
}
