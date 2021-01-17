package com.qitson.proyectoFinal.Funcionalidad1;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private static int _i = 0;
    private int _id;
    private String
        _nombre,
        _apellido,
        _nombreDeUsuario,
        _correoInstitucional;

    private PerfilAcademico _perfil;

    private ArrayList<Proyecto> proyectos =  new ArrayList<>();
    private ArrayList<PublicacionProyecto> publicaciones =  new ArrayList<>();

    public Usuario( String _nombre, String _apellido, String _nombreDeUsuario,  String _correoInstitucional, PerfilAcademico _perfil) {
            this._correoInstitucional = _correoInstitucional;
            this._nombre = _nombre;
            this._apellido = _apellido;
            this._nombreDeUsuario = _nombreDeUsuario;
            this._perfil = _perfil;
            this._id = ++_i;
    }

    public String get_nombreDeUsuario() {
        return _nombreDeUsuario;
    }

    public PerfilAcademico get_perfil() {
        return _perfil;
    }
    public String get_nombre_completo(){
        return this._nombre + " " + this._apellido;
    }


    public void añadirProyecto(String nombre, String descripcionProyecto, String area , String _pathImagenProyecto, Date _fechaCreacion, String descripcionPublicacion) throws Exception {
        Proyecto proyecto = new Proyecto(nombre, descripcionProyecto,area, _pathImagenProyecto, _fechaCreacion, this);
        proyectos.add(proyecto);
        PublicacionProyecto publicacion = new PublicacionProyecto(descripcionPublicacion, proyecto);
        añadirPublicacion(publicacion);
    }

    public void añadirPublicacion(PublicacionProyecto publicacion){
        publicaciones.add(publicacion);
    }
    public void mostrarMuro() throws InterruptedException {
        for (PublicacionProyecto p: publicaciones) {
            System.out.println(p.mostrarPublicacion());
        }
    }
}
