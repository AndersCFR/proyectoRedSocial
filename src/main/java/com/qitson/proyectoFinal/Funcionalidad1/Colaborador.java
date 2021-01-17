package com.qitson.proyectoFinal.Funcionalidad1;

import java.util.ArrayList;

public class Colaborador {
    private int idColaborador;
    private ArrayList<String> aportaciones = new ArrayList<>();
    private Usuario usuario;

    public Colaborador(int idColaborador, ArrayList<String> aportaciones) {
        this.idColaborador = idColaborador;
        this.aportaciones = aportaciones;
    }

    public Colaborador(Usuario user) {
      this.usuario = user;
    }

    public void crearAporte(String aporte){
        aportaciones.add(aporte);
    }

    public void eliminarAporte(String aporte){
        aportaciones.remove(aporte);
    }

    public int obtenerNumeroAportaciones(){
        int numeroAportaciones = aportaciones.size();
        return numeroAportaciones;
    }
}
