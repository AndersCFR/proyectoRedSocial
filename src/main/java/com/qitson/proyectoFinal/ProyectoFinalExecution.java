package com.qitson.proyectoFinal;
import com.qitson.datos.Data;
import com.qitson.proyectoFinal.Funcionalidad1.PerfilAcademico;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;
import com.qitson.proyectoFinal.Funcionalidad1.Usuario;
import com.qitson.proyectoFinal.Funcionalidad2.BuscadorProyectos;

import java.util.ArrayList;
import java.util.Date;

public class ProyectoFinalExecution {
    public static void main(String[] args) throws Exception {
        PerfilAcademico perfil1 = new PerfilAcademico(
                "E.P.N",
                "Ingeniería de Sistemas",
                "Ingeniería de Software"
        );

        Usuario user1 = new Usuario(
                "Alejandro",
                "Llanganate",
                "alejo17",
                "luis.llanganate@epn.edu.ec",
                perfil1
        );

        user1.publicarProyecto("BCI",
                "Proyecto para identificar patrones de conducta de BCI",
                "Ciencias de la computación",
                "https://www.surveycto.com/wp-content/uploads/2018/04/ai-and-dev.jpg",
                new Date(),
                "Les comparto mi nuevo proyecto!");

        System.out.println("**************************** QITSON SOCIAL NETWORK - PROJECT PUBLICATION ****************************");
        user1.mostrarMuro();

        System.out.println("\n**************************** QITSON SOCIAL NETWORK - COLABORATE IN A PROJECT ****************************");
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        BuscadorProyectos b = new BuscadorProyectos();
        System.out.println("Búsqueda de proyectos en el área de Informática que estén disponibles a colaboración");

        ArrayList<Proyecto> proyectosInformatica = new ArrayList<>();
        ArrayList<Proyecto> coincidencias = new ArrayList<>();
        proyectosInformatica = b.buscarPorAreaInvestigacion(dataProyectos,"INFORMATICA");

        for(Proyecto p : proyectosInformatica){
            if(b.verificarDisponibilidadProyecto(p)==true){
                coincidencias.add(p);
            }
        }
        int numeroCoincidencias = coincidencias.size();
        System.out.println("Proyectos de Informática listos para colaboración: "+numeroCoincidencias);

        for(int i=0; i<numeroCoincidencias; i++){
            System.out.println("ID: "+coincidencias.get(i).get_idProyecto()+" | "+" NOMBRE:  "+coincidencias.get(i).get_nombre() + " | PROPIETARIO: " + coincidencias.get(i).get_propietario().get_nombre_completo());
        }

    }
}
