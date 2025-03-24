package controlador;

import modelo.FormularioModelo;
import vista.FormularioPanel;
import vista.VentanaPrincipal;

import javax.swing.*;

public class FormularioControlador {

    private FormularioModelo modelo;
    private VentanaPrincipal vista;

    public FormularioControlador(FormularioModelo modelo, VentanaPrincipal vista) {
        this.modelo = modelo;
        this.vista = vista;

        FormularioPanel panel = vista.getFormularioPanel();
        panel.enviarBtn.addActionListener(e -> procesarFormulario());
    }

    private void procesarFormulario() {
        FormularioPanel panel = vista.getFormularioPanel();

        String nombre = panel.nombreField.getText().trim();
        String genero = panel.generoM.isSelected() ? "Masculino" :
                        panel.generoF.isSelected() ? "Femenino" : "";
        boolean acepta = panel.aceptoCheck.isSelected();
        String comentarios = panel.comentariosArea.getText().trim();
        String opcion = (String) panel.opcionesBox.getSelectedItem();

        if (nombre.isEmpty()) {
            mostrarError("El campo 'Nombre' es obligatorio.");
            return;
        }

        if (genero.isEmpty()) {
            mostrarError("Seleccione un género.");
            return;
        }

        if (!acepta) {
            mostrarError("Debe aceptar los términos y condiciones.");
            return;
        }

        if (opcion.equals("Seleccione...")) {
            mostrarError("Seleccione una opción válida.");
            return;
        }

        modelo.setNombre(nombre);
        modelo.setGenero(genero);
        modelo.setAceptaTerminos(acepta);
        modelo.setComentarios(comentarios);
        modelo.setOpcionSeleccionada(opcion);

        String resumen = "Nombre: " + modelo.getNombre()
                + "\nGénero: " + modelo.getGenero()
                + "\nOpción: " + modelo.getOpcionSeleccionada()
                + "\nComentario: " + modelo.getComentarios()
                + "\nCampo oculto: " + modelo.getCampoOculto();

        JOptionPane.showMessageDialog(vista, resumen, "Datos enviados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(vista, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // 🔷 Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioModelo modelo = new FormularioModelo();
            VentanaPrincipal vista = new VentanaPrincipal();
            new FormularioControlador(modelo, vista);
            vista.setVisible(true);
        });
    }
}
