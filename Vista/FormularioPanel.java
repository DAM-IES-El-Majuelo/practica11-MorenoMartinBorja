package vista;

import javax.swing.*;
import java.awt.*;

public class FormularioPanel extends JPanel {

    public JTextField nombreField;
    public JRadioButton generoM, generoF;
    public JCheckBox aceptoCheck;
    public JTextArea comentariosArea;
    public JComboBox<String> opcionesBox;
    public JButton enviarBtn;

    public FormularioPanel() {
        setLayout(new GridLayout(6, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Género:"));
        generoM = new JRadioButton("Masculino");
        generoF = new JRadioButton("Femenino");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(generoM);
        grupoGenero.add(generoF);
        JPanel generoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        generoPanel.add(generoM);
        generoPanel.add(generoF);
        add(generoPanel);

        add(new JLabel("Términos:"));
        aceptoCheck = new JCheckBox("Acepto los términos y condiciones");
        add(aceptoCheck);

        add(new JLabel("Comentarios:"));
        comentariosArea = new JTextArea(3, 20);
        add(new JScrollPane(comentariosArea));

        add(new JLabel("Opción:"));
        opcionesBox = new JComboBox<>(new String[]{"Seleccione...", "Opción 1", "Opción 2", "Opción 3"});
        add(opcionesBox);

        enviarBtn = new JButton("Enviar");
        add(enviarBtn);
        add(new JLabel()); // celda vacía
    }
}
