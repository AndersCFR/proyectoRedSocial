package com.qitson.proyectoFinal.Funcionalidad2;


import com.qitson.datos.Data;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;
import com.qitson.proyectoFinal.Funcionalidad2.BuscadorProyectos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(value = Parameterized.class)
public class ProjectDateParametersTest {
    private int año_publicacion;


    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{1060});
        objects.add(new Object[]{1500});
        objects.add(new Object[]{1950});
        objects.add(new Object[]{1830});
        objects.add(new Object[]{-2021});

        return objects;
    }

    public ProjectDateParametersTest(int año_publicacion){
        this.año_publicacion = año_publicacion;
    }

    @Test(expected = Exception.class)
    public void given_year_project_when_search_then_error() throws Exception {
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        BuscadorProyectos b = new BuscadorProyectos();
        ArrayList<Proyecto> coincidencias = b.buscarPorAño(dataProyectos, año_publicacion);
    }

}
