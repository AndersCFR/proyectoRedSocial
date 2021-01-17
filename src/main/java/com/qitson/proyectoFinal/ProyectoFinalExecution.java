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


    }
}
