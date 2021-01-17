package com.qitson.proyectoFinal.Funcionalidad1;

import java.util.ArrayList;
import java.util.Date;

public class PublicacionProyecto implements Publicacion{
    private static int _i = 0;
    private int _idPublicacionProyecto;
    private final String _tipo = "PROYECTO";
    private String _descripcionPublicacion;
    private Date _fechaPublicacion;
    private ArrayList<Reaccion> _reacciones = new ArrayList<Reaccion>();
    private ArrayList<Comentario> _comentarios = new ArrayList<Comentario>();
    private Proyecto _proyecto;


    public PublicacionProyecto(String descripcionPublicacion, Proyecto proyecto) throws Exception {
        Validación.validarNumeroCaracteres(descripcionPublicacion, 85);
        _descripcionPublicacion = descripcionPublicacion;
        this._proyecto = proyecto;
        this._idPublicacionProyecto = ++_i;
        this._fechaPublicacion = new Date();
    }

    @Override
    public String mostrarPublicacion() throws InterruptedException {
        String info= "";
        String separador = "\n-----------------------------------------------------------------\n";
        info += imprimirInfoUsuario()+imprimirInfoPublicacion()+
                separador+_proyecto.imprimirInfoProyecto(this)+
                separador+imprimirReaciones()+imprimirComentarios();
        Thread.sleep(100);
        return info;
    }

    public String imprimirInfoUsuario(){
        String infoUsuario = this._proyecto.get_propietario().get_nombre_completo()+
                " ("+this._proyecto.get_propietario().get_nombreDeUsuario()+") - "+
                this._proyecto.get_propietario().get_perfil().get_carreraUniversitaria()+", "+
                this._proyecto.get_propietario().get_perfil().get_universidad()+"\n";
        return infoUsuario;
    }

    public String imprimirInfoPublicacion(){
        String infoPublicacion =
                "Tipo de publicación: "+this._tipo+"\n"+
                        "Descripción de la publicación: "+this._descripcionPublicacion+"\n"+
                        "Fecha publicación: "+this._fechaPublicacion;
        return infoPublicacion;
    }

    public String imprimirReaciones(){
        return("Reacciones: "+ obtenerNumeroDeReacciones());
    }

    public int obtenerNumeroDeReacciones(){
        int cantidadReacciones = _reacciones.size();
        return cantidadReacciones;
    }

    public String imprimirComentarios(){
        String comentarios = "";
        if (_comentarios.size() == 0){
            comentarios += "\nPor el momento no se han generado comentarios";
        }else{
            for (Comentario comentario: _comentarios) {
                comentarios += ("Fecha: "+comentario.get_fechaComentario()+"\n"+
                        "Usuario: "+comentario.get_publicador().get_nombre_completo()+"\n"+
                        "Contenido: "+comentario.get_contenido()+"\n");
            }
        }
        return comentarios;
    }

    @Override
    public void agregarReacion(Reaccion tipoReaccion) {
        _reacciones.add(tipoReaccion);
    }

    @Override
    public void agregarComentario(Comentario comentario) {
        _comentarios.add(comentario);
    }

    @Override
    public boolean share(Usuario usuario) {
        if(this._proyecto.get_estado() != Proyecto.Estado.CERRADO && usuario.get_nombreDeUsuario() != this._proyecto.get_propietario().get_nombreDeUsuario()){
            return true;
        }
        return false;
    }
}