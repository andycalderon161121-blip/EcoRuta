package pe.ecoruta.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import pe.ecoruta.modelo.ResultadoRuta;
import pe.ecoruta.servicio.Planificador;
import pe.ecoruta.strategy.RutaEconomica;
import pe.ecoruta.strategy.RutaRapida;
import pe.ecoruta.strategy.RutaSegura;
import pe.ecoruta.strategy.RutaStrategy;

public class VentanaPrincipal extends JFrame {
    private final JComboBox<String> cboEstrategia;
    private final JLabel lblDescripcion;
    private final JTextArea txtResultado;
    private final Planificador planificador;

    public VentanaPrincipal() {
        planificador = new Planificador(new RutaRapida());

        setTitle("EcoRuta Piura - Strategy");
        setSize(720, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(245, 248, 250));
        setLayout(new BorderLayout(15, 15));

        JLabel titulo = new JLabel("ECORUTA PIURA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 27));
        titulo.setForeground(new Color(22, 91, 78));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 0, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(5, 1, 8, 8));
        centro.setBackground(new Color(245, 248, 250));
        centro.setBorder(BorderFactory.createEmptyBorder(10, 45, 10, 45));

        JLabel subtitulo = new JLabel("Planificador inteligente de entregas", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.BOLD, 17));

        JLabel instruccion = new JLabel("Elige qué quieres priorizar:", SwingConstants.CENTER);
        instruccion.setFont(new Font("Arial", Font.PLAIN, 15));

        cboEstrategia = new JComboBox<>(new String[]{"Rápida", "Económica", "Segura"});
        cboEstrategia.setFont(new Font("Arial", Font.PLAIN, 16));

        lblDescripcion = new JLabel("Prioriza llegar en el menor tiempo.", SwingConstants.CENTER);
        lblDescripcion.setFont(new Font("Arial", Font.ITALIC, 13));

        JButton btnCalcular = new JButton("CALCULAR MI RUTA");
        btnCalcular.setFont(new Font("Arial", Font.BOLD, 15));
        btnCalcular.setBackground(new Color(22, 120, 95));
        btnCalcular.setForeground(Color.WHITE);
        btnCalcular.setFocusPainted(false);

        centro.add(subtitulo);
        centro.add(instruccion);
        centro.add(cboEstrategia);
        centro.add(lblDescripcion);
        centro.add(btnCalcular);
        add(centro, BorderLayout.CENTER);

        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 15));
        txtResultado.setBackground(Color.WHITE);
        txtResultado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 220, 220)),
                BorderFactory.createEmptyBorder(12, 18, 12, 18)));
        txtResultado.setText("Tu resultado aparecerá aquí.\n\nPrueba las tres estrategias para comparar.");
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBackground(new Color(245, 248, 250));
        panelResultado.setBorder(BorderFactory.createEmptyBorder(0, 45, 25, 45));
        panelResultado.add(txtResultado, BorderLayout.CENTER);
        panelResultado.setPreferredSize(new java.awt.Dimension(720, 145));
        add(panelResultado, BorderLayout.SOUTH);

        cboEstrategia.addActionListener(e -> cambiarEstrategia());
        btnCalcular.addActionListener(e -> mostrarResultado());
    }

    private void cambiarEstrategia() {
        String seleccion = (String) cboEstrategia.getSelectedItem();
        RutaStrategy estrategia;

        switch (seleccion) {
            case "Económica":
                estrategia = new RutaEconomica();
                break;
            case "Segura":
                estrategia = new RutaSegura();
                break;
            default:
                estrategia = new RutaRapida();
                break;
        }

        planificador.setEstrategia(estrategia);
        lblDescripcion.setText(estrategia.getDescripcion());
    }

    private void mostrarResultado() {
        ResultadoRuta resultado = planificador.planificar();
        txtResultado.setText(
                "RESULTADO: " + resultado.getNombre() + "\n"
                + "Tiempo estimado : " + resultado.getMinutos() + " minutos\n"
                + String.format("Costo estimado : S/ %.2f%n", resultado.getCosto())
                + "Incidencias     : " + resultado.getIncidencias() + "\n\n"
                + "Estrategia aplicada: " + planificador.getEstrategia().getClass().getSimpleName()
        );
    }
}
