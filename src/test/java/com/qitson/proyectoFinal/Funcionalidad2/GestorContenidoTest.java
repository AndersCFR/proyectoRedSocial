package com.qitson.proyectoFinal.Funcionalidad2;

import com.qitson.datos.Data;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;
import com.qitson.proyectoFinal.Funcionalidad2.GestorContenido;
import org.mockito.Mockito;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class GestorContenidoTest {
    @Test
    public void given_a_proyect_when_suggest_then_ok(){
        GestorContenido gc = Mockito.mock(GestorContenido.class);
        Proyecto proyecto = Data.getDataProyectos().get(0);
        ArrayList<Proyecto> recomendaciones = new ArrayList<>();
        Mockito.when(gc.sugerirProyectos(proyecto)).thenReturn(recomendaciones);
        assertNotNull(recomendaciones);
    }
}