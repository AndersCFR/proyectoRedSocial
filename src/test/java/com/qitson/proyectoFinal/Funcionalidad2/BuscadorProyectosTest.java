package com.qitson.proyectoFinal.Funcionalidad2;
import com.qitson.datos.Data;
import com.qitson.proyectoFinal.Funcionalidad1.PerfilAcademico;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;
import com.qitson.proyectoFinal.Funcionalidad1.Usuario;
import com.qitson.proyectoFinal.Funcionalidad2.BuscadorProyectos;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class BuscadorProyectosTest {

    @Test
    public void given_proyect_name_when_search_then_ok() {
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        int expected = 6; // coincidencias esperadas;
        BuscadorProyectos b = new BuscadorProyectos();
        int actual =  b.buscarPorNombreProyecto(dataProyectos, "BCI").size();
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test(timeout = 150)
    public void given_project_owner_name_when_search_then_timeout() {
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        int no_expected = 0;
        BuscadorProyectos b = new BuscadorProyectos();
        int actual =  b.buscarPorNombrePropietario(dataProyectos, "Alejandro Llanganate").size();
        assertNotEquals(no_expected, actual);
    }

    @Test(expected = Exception.class)
    public void given_year_project_when_search_then_error() throws Exception {
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        BuscadorProyectos b = new BuscadorProyectos();
        ArrayList<Proyecto> coincidencias = b.buscarPorAño(dataProyectos, 1400);
    }

    @Test
    public void given_project_name_and_index_of_same_project_when_search_then_ok(){
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        Proyecto expectedObject = dataProyectos.get(1);
        BuscadorProyectos b = new BuscadorProyectos();
        Proyecto actualObject= b.buscarPorNombreProyecto(dataProyectos,"Visión Artificial").get(0);
        assertSame(expectedObject, actualObject);
    }

    @Test
    public void given_project_area_when_search_then_ok() {
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        ArrayList<Proyecto> no_expected = dataProyectos;
        BuscadorProyectos b = new BuscadorProyectos();
        ArrayList<Proyecto> coincidencias = b.buscarPorAreaInvestigacion(dataProyectos, "CIENCIAS_DE_LA_TIERRA");
        assertNotSame(no_expected, coincidencias);
    }

    @Test
    public void given_project_when_verify_availability_then_ok(){
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        BuscadorProyectos b = new BuscadorProyectos();
        boolean disponiblidad = b.verificarDisponibilidadProyecto(dataProyectos.get(0));
        assertTrue(disponiblidad);
    }

    @Test
    public void verify_data_project_is_not_empty_then_ok(){
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        assertNotNull(dataProyectos);
    }

    @Test
    public void verify_false_if_the_project_is_not_register_in_data_then_ok(){
        PerfilAcademico perfilX = new PerfilAcademico("ESPE", "Electrónica",
                "Ing. Control y Automatización");
        Usuario usuarioX = new Usuario("Jose", "Perez", "pepoCK",
                "pepotup@espe.com", perfilX);
        Proyecto proyecto = new Proyecto(
                "Nueva Generación de Microcontroladores",
                "Análisis de aplicabilidad de los últimos microcontroladores en la electronica",
                "ELECTRONICA", usuarioX);
        Proyecto proyectoNoRegistrado =proyecto;
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        BuscadorProyectos b = new BuscadorProyectos();
        boolean expected =b.verificarExistenciaProyecto(dataProyectos, proyectoNoRegistrado);
        assertFalse(expected);
    }

}
