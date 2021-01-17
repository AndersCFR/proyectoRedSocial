package com.qitson.proyectoFinal.Funcionalidad2;

import com.qitson.datos.Data;


import java.util.*;

import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;
import com.qitson.proyectoFinal.Funcionalidad2.BuscadorProyectos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class BuscadorProyectosParametersTest {

    private int indice_proyecto;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{0});
        objects.add(new Object[]{2});
        return objects;
    }

    public BuscadorProyectosParametersTest(int indice_proyecto){
        this.indice_proyecto = indice_proyecto;

    }

    @Test
    public void given_state_project_when_verify_availability_then_ok(){
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        BuscadorProyectos b = new BuscadorProyectos();
        boolean disponibilidad = b.verificarDisponibilidadProyecto(dataProyectos.get(indice_proyecto));
        assertTrue(disponibilidad);
    }

}