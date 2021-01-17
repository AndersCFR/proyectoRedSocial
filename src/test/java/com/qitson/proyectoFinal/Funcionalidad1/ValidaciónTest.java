package com.qitson.proyectoFinal.Funcionalidad1;


import com.qitson.datos.Data;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ValidaciónTest {

    @Test(expected = Exception.class)
    public void given_maxcharacters_then_ok() throws Exception{
        ArrayList<Proyecto> dataProyectos = Data.getDataProyectos();
        String descripcion = dataProyectos.get(0).get_descripcion();
        Validación.validarNumeroCaracteres(descripcion,25);
    }
}
