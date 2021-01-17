package com.qitson.proyectoFinal.Funcionalidad1;

public interface Publicacion {
    public String mostrarPublicacion() throws InterruptedException;
    public void agregarReacion(Reaccion tipoReaccion);
    public void agregarComentario(Comentario comentario);
    public boolean share(Usuario usuario);
}


