package com.qitson.proyectoFinal.Funcionalidad1;

import java.util.Date;

public class Comentario {
    private  static int i = 0;
    private int _idComentario;
    private Usuario _publicador;
    private String _contenido;
    private Date _fechaComentario;

    public Comentario(Usuario _publicadorComentario, String _contenido) {
        this._publicador = _publicadorComentario;
        this._contenido = _contenido;
        this._fechaComentario = new Date();
        this._idComentario = ++i;
    }

    public Usuario get_publicador() {
        return _publicador;
    }

    public String get_contenido() {
        return _contenido;
    }

    public Date get_fechaComentario() {
        return _fechaComentario;
    }
}
