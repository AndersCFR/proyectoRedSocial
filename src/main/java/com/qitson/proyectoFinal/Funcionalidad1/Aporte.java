package com.qitson.proyectoFinal.Funcionalidad1;

import java.util.Date;

public class Aporte {
    private static int i = 0;
    private int _idAporte;
    private String _descripcion;
    private Date fechaAporte;

    public Aporte(String description) {
        this._idAporte = ++i;
        this._descripcion = description;
        this.fechaAporte = new Date();
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Date getFechaAporte() {
        return fechaAporte;
    }

    public void setFechaAporte(Date fechaAporte) {
        this.fechaAporte = fechaAporte;
    }
}
