package com.qitson.datos;

import com.qitson.proyectoFinal.Funcionalidad1.Aporte;
import com.qitson.proyectoFinal.Funcionalidad1.PerfilAcademico;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;
import com.qitson.proyectoFinal.Funcionalidad1.Usuario;
import com.qitson.proyectoFinal.Funcionalidad2.ColaboracionRequest;

import java.util.ArrayList;
import java.util.Date;

public class Data {
    private static final ArrayList<Proyecto> proyectos = new ArrayList<>();
    public static ArrayList<ColaboracionRequest> solicitudes = new ArrayList<>();
    public static ArrayList<Aporte> aportes = new ArrayList<>();


    public static ArrayList<Proyecto> getDataProyectos(){
        PerfilAcademico perfil1 = new PerfilAcademico(
                "Escuela Politécnica Nacional",
                "Ingeniería de Sistemas",
                "Ingeniería de Software"
        );

        PerfilAcademico perfil2 = new PerfilAcademico(
                "Universidad Salesiana del Ecuador",
                "Ingeniería de Sistemas",
                "Ciencias de la Computación"
        );

        Usuario user1 = new Usuario(
                "Alejandro",
                "Llanganate",
                "alejo17",
                "luis.llanganate@epn.edu.ec",
                perfil1
        );

        Usuario user2 = new Usuario(
                "Edison",
                "Quimbiamba",
                "psyduck",
                "edi@gmail.com",
                perfil1
        );

        Proyecto proyecto1 = new Proyecto(
                "BCI",
                "Proyecto para identificar patrones de conducta de BCI",
                "INFORMATICA",
                user1
        );

        Proyecto proyecto2 = new Proyecto(
                "Visión Artificial",
                "Proyecto sobre computer vision",
                "INFORMATICA",
                user2
        );

        Proyecto proyecto3 = new Proyecto(
                "Web Assembly",
                "Construcción de una aplicación de simulación",
                "INFORMATICA",
                user2
        );

        Proyecto proyecto4 = new Proyecto(
                "Vulcanología",
                "Estudio de volcanes de pichincha",
                "CIENCIAS_DE_LA_TIERRA",
                user2
        );

        Proyecto proyecto5 = new Proyecto(
                "BCI",
                "Análisis predictivo de comportamiento",
                "INFORMATICA",
                user2
        );

        proyecto1.set_estado(Proyecto.Estado.BUSCANDO_COLABORACION);
        proyecto2.set_estado(Proyecto.Estado.BUSCANDO_COLABORACION);
        proyecto4.set_estado(Proyecto.Estado.CERRADO);
        proyecto5.set_estado(Proyecto.Estado.CERRADO);
        Date fecha_p2 = new Date("9/12/2017");
        proyecto2.set_fechaCreacion(fecha_p2);

        proyectos.add(proyecto1);
        proyectos.add(proyecto2);
        proyectos.add(proyecto3);
        proyectos.add(proyecto4);
        proyectos.add(proyecto5);

        return proyectos;
    }



}
