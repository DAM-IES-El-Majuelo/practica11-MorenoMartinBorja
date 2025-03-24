package vista;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.function.Supplier;

public class VentanaPrincipal extends JFrame {

    private FormularioPanel formularioPanel;

    public VentanaPrincipal() {
        setTitle("Formulario HTML5 simulado en Swing");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        setIconImage(new ImageIcon("resources/icono.png").getImage());

        JLabel header = new JLabel("Aplicación Java Swing - Simulación HTML5", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(header, BorderLayout.NORTH);

        formularioPanel = new FormularioPanel();
        add(formularioPanel, BorderLayout.CENTER);

        // Cargar HTML
        JEditorPane htmlPane = new JEditorPane();
        htmlPane.setEditable(false);
        htmlPane.setContentType("text/html");

        try {
            File htmlFile = new File("resources/estilo.html");
            htmlPane.setPage(htmlFile.toURI().toURL());
        } catch (Exception e) {
            htmlPane.setText("<html><body><p>Error al cargar HTML.</p></body></html>");
        }

        // 🔗 Añadir interacción al HTML
        htmlPane.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    String url = e.getDescription();

                    if (url.equals("#verDatos")) {
                        Supplier<String> datosProveedor = getDatosFormulario();
                        JOptionPane.showMessageDialog(VentanaPrincipal.this, datosProveedor.get(), "Datos del Formulario", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(htmlPane);
        scrollPane.setPreferredSize(new Dimension(300, 0));
        add(scrollPane, BorderLayout.EAST);

        JLabel footer = new JLabel("© 2025 - Proyecto Java Swing", SwingConstants.CENTER);
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(footer, BorderLayout.SOUTH);
    }

    public FormularioPanel getFormularioPanel() {
        return formularioPanel;
    }

    // 🔄 Método para obtener los datos del formulario (aunque aún no validados)
    private Supplier<String> getDatosFormulario() {
        return () -> {
            String nombre = formularioPanel.nombreField.getText();
            String genero = formularioPanel.generoM.isSelected() ? "Masculino" :
                            formularioPanel.generoF.isSelected() ? "Femenino" : "No seleccionado";
            String comentarios = formularioPanel.comentariosArea.getText();
            String opcion = (String) formularioPanel.opcionesBox.getSelectedItem();

            return "Nombre: " + nombre +
                   "\nGénero: " + genero +
                   "\nOpción: " + opcion +
                   "\nComentarios: " + comentarios;
        };
    }
}
