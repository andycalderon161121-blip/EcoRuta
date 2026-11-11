package pe.ecoruta.servicio;

import pe.ecoruta.modelo.ResultadoRuta;
import pe.ecoruta.strategy.RutaStrategy;

public class Planificador {
    private RutaStrategy estrategia;

    public Planificador(RutaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(RutaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public ResultadoRuta planificar() {
        return estrategia.calcularRuta();
    }

    public RutaStrategy getEstrategia() {
        return estrategia;
    }
}
