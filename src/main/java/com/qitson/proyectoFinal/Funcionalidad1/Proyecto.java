package com.qitson.proyectoFinal.Funcionalidad1;

import com.qitson.proyectoFinal.Funcionalidad1.Colaborador;
import com.qitson.proyectoFinal.Funcionalidad1.PublicacionProyecto;
import com.qitson.proyectoFinal.Funcionalidad1.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class Proyecto {

    public static enum Estado{
        BUSCANDO_COLABORACION, CERRADO;
    }

    enum AreaInvestigacion{
        INFORMATICA, CIENCIAS_MEDICAS, CIENCIAS_POLITICAS,
        CIENCIAS_SOCIALES, CIENCIAS_AGRARIAS, ARQUITECTURA,
        CIENCIAS_EXACTAS, CIENCIAS_NATURALES, CIENCIAS_DE_LA_TIERRA
    }

    private static int _i = 0;
    private int _idProyecto;
    private Estado _estado;
    private String
        _nombre,
        _descripcion,
        _areaInvestigacion,
        _pathImagenProyecto
    ;
    private Date _fechaCreacion;
    private Usuario _propietario;
    ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    private int numMaximoColaboradores;

    public Proyecto(String _nombre, String _descripcion, String _areaInvestigacion, String _pathImagenProyecto, Date _fechaCreacion, Usuario _propietario) {
        this._nombre = _nombre;
        this._descripcion = _descripcion;
        this._areaInvestigacion = _areaInvestigacion;
        this._pathImagenProyecto = _pathImagenProyecto;
        this._fechaCreacion = _fechaCreacion;
        this._propietario = _propietario;
        this._idProyecto = ++_i;
        this._estado = Estado.BUSCANDO_COLABORACION;
    }

    public Proyecto(String _nombre, String _descripcion, String _areaInvestigacion, Usuario _propietario) {
        this._nombre = _nombre;
        this._descripcion = _descripcion;
        this._areaInvestigacion = _areaInvestigacion;
        this._pathImagenProyecto = "";
        this._fechaCreacion = new Date();
        this._propietario = _propietario;
        this._idProyecto = ++_i;
        this._estado = Estado.BUSCANDO_COLABORACION;
    }

    public void añadirColaborador(Colaborador colaborador){
        colaboradores.add(colaborador);
    }

    public void quitarColaborador(Colaborador colaborador){
        colaboradores.remove(colaborador);
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public Usuario get_propietario() {
        return _propietario;
    }

    public int get_ano_pulicacion(){
        return _fechaCreacion.getYear();
    }

    public void set_estado(Estado _estado) {
        this._estado = _estado;
    }

    public void set_fechaCreacion(Date fecha){
        this._fechaCreacion = fecha;
    }
    
    public int obtenerNumeroColaboradores(){
        return this.colaboradores.size();
    }

    public String imprimirInfoProyecto(PublicacionProyecto publicacionProyecto){
        String infoProyecto = "Nombre del proyecto: "+ this._nombre +"\n"+
                "Area de investigación: "+ this._areaInvestigacion +"\n"+
                "Descripción del proyecto: "+ this.get_descripcion()+"\n"+
                "Fecha de creación: "+ this._fechaCreacion +"\n"+
                "Número de colaboradores por el momento: "+ obtenerNumeroColaboradores();
        return infoProyecto;
    }

    public String get_nombre() {
        return _nombre;
    }

    public Date get_fechaCreacion() {
        return _fechaCreacion;
    }

    public int get_idProyecto() {
        return _idProyecto;
    }

    public Estado get_estado() {
        return _estado;
    }

    public String get_areaInvestigacion() {
        return _areaInvestigacion;
    }
}
