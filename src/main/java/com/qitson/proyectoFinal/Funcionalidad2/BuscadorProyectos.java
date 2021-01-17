package com.qitson.proyectoFinal.Funcionalidad2;

import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;

import java.util.ArrayList;



public class BuscadorProyectos {


    public BuscadorProyectos() {};

    public ArrayList<Proyecto> buscarPorNombreProyecto(ArrayList<Proyecto> proyectos, String nombreProyecto){
        ArrayList<Proyecto> resultados = new ArrayList<>();
        for (Proyecto proyecto:proyectos) {
            if (proyecto.get_nombre().equals(nombreProyecto)) {
                resultados.add(proyecto);
            }
        }

        return resultados;
    }

    public ArrayList<Proyecto> buscarPorNombrePropietario(ArrayList<Proyecto> proyectos, String nombrePropietario) {
        ArrayList<Proyecto> resultados = new ArrayList<>();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Proyecto proyecto:proyectos) {
            if (proyecto.get_propietario().get_nombre_completo().equalsIgnoreCase(nombrePropietario)){
                resultados.add(proyecto);
            }
        }
        return resultados;
    }

    public ArrayList<Proyecto> buscarPorAreaInvestigacion(ArrayList<Proyecto> proyectos, String area){
        ArrayList<Proyecto> resultados = new ArrayList<>();

        for (Proyecto proyecto:proyectos)
            if(proyecto.get_areaInvestigacion() == area)
                resultados.add(proyecto);
        return resultados;
    }

    public ArrayList<Proyecto> buscarPorUniversidad(ArrayList<Proyecto> proyectos, String nombreUniversidad){
        ArrayList<Proyecto> resultados = new ArrayList<>();

        for (Proyecto proyecto:proyectos)
            if(proyecto.get_propietario().get_perfil().get_universidad() == nombreUniversidad)
                resultados.add(proyecto);
        return resultados;
    }

    public ArrayList<Proyecto> buscarPorAño(ArrayList<Proyecto> proyectos, int año) throws Exception {

        if(año < 1995 || año > 2021){
            throw new Exception("Año fuera de rango permitido");
        }

        ArrayList<Proyecto> resultados = new ArrayList<>();

        for (Proyecto proyecto:proyectos) {
            if(proyecto.get_fechaCreacion().getYear() == año) {
                resultados.add(proyecto);
            }
        }
        return resultados;
    }

    public boolean verificarExistenciaProyecto(ArrayList<Proyecto> proyectos, Proyecto proyecto){
        int[] ids = new int[proyectos.size()];
        for (int i = 0; i < proyectos.size(); i++){
            ids[i] = proyectos.get(i).get_idProyecto();
        }
        for (int i = 0; i < proyectos.size(); i++){
            if(ids[i] == proyecto.get_idProyecto()){
                return true;
            }
        }
        return false;
    }

    public boolean verificarDisponibilidadProyecto(Proyecto proyecto){
        return proyecto.get_estado() == Proyecto.Estado.BUSCANDO_COLABORACION;
    }

}
