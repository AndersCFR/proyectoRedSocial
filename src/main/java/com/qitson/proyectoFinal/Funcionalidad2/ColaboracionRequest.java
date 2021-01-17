package com.qitson.proyectoFinal.Funcionalidad2;

import com.qitson.proyectoFinal.Funcionalidad1.Colaborador;
import com.qitson.proyectoFinal.Funcionalidad1.Aporte;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;

import java.util.Date;

public class ColaboracionRequest {

    private Proyecto _proyecto;
    private Date _fechaSolicitudColaboracion;
    private Colaborador _colaborador;
    private Aporte _aporte;

    public ColaboracionRequest(Proyecto _proyecto , Colaborador colaborador, Aporte aporte) {
        this._proyecto = _proyecto;
        this._fechaSolicitudColaboracion = new Date();
        this._colaborador = colaborador;
        this._aporte = aporte;
    }

    public Proyecto get_proyecto() {
        return _proyecto;
    }

    public void set_proyecto(Proyecto _proyecto) {
        this._proyecto = _proyecto;
    }

    public Date get_fechaSolicitudColaboracion() {
        return _fechaSolicitudColaboracion;
    }

    public void set_fechaSolicitudColaboracion(Date _fechaSolicitudColaboracion) {
        this._fechaSolicitudColaboracion = _fechaSolicitudColaboracion;
    }

    public Colaborador get_colaborador() {
        return _colaborador;
    }

    public void set_colaborador(Colaborador _colaborador) {
        this._colaborador = _colaborador;
    }

    public Aporte get_aporte() {
        return _aporte;
    }

    public void set_aporte(Aporte _aporte) {
        this._aporte = _aporte;
    }
}
