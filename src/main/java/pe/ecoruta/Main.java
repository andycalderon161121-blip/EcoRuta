package pe.ecoruta;

import javax.swing.SwingUtilities;
import pe.ecoruta.vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
