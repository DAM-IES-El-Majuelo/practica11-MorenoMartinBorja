package modelo;

public class FormularioModelo {
    private String nombre;
    private String genero;
    private boolean aceptaTerminos;
    private String comentarios;
    private String opcionSeleccionada;
    private String campoOculto = "valorOculto";

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public boolean isAceptaTerminos() { return aceptaTerminos; }
    public void setAceptaTerminos(boolean aceptaTerminos) { this.aceptaTerminos = aceptaTerminos; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public String getOpcionSeleccionada() { return opcionSeleccionada; }
    public void setOpcionSeleccionada(String opcionSeleccionada) { this.opcionSeleccionada = opcionSeleccionada; }

    public String getCampoOculto() { return campoOculto; }
}
