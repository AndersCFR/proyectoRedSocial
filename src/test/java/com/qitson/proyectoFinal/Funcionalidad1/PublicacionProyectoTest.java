package com.qitson.proyectoFinal.Funcionalidad1;

import com.qitson.datos.Data;
import com.qitson.proyectoFinal.Funcionalidad2.BuscadorProyectos;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PublicacionProyectoTest {

    @Test(timeout = 1000)
    public void given_publication_when_show_publication_then_timeout() throws Exception {
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        String descripcion = "Ejemplo de descripción.";
        PublicacionProyecto publicacion  = new PublicacionProyecto(descripcion, dataProyectos.get(0));
        assertNotNull(publicacion.mostrarPublicacion());
    }

    @Test
    public void given_a_user_when_share_project_to_other_user_then_ok() throws Exception {
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        String cadena = "Ejemplo de descripción.";
        PublicacionProyecto publicacion  = new PublicacionProyecto(cadena, dataProyectos.get(1));
        boolean actual = publicacion.share(dataProyectos.get(0).get_propietario()); // diferent creator
        assertTrue(actual);
    }


}