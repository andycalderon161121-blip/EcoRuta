package pe.ecoruta.strategy;

import pe.ecoruta.modelo.ResultadoRuta;

public interface RutaStrategy {
    ResultadoRuta calcularRuta();
    String getNombre();
    String getDescripcion();
}
