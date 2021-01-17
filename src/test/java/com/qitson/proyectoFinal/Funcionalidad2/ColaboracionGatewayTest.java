package com.qitson.proyectoFinal.Funcionalidad2;

import com.qitson.datos.Data;
import com.qitson.proyectoFinal.Funcionalidad1.Aporte;
import com.qitson.proyectoFinal.Funcionalidad1.Colaborador;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;
import com.qitson.proyectoFinal.Funcionalidad2.ColaboracionGateway;
import com.qitson.proyectoFinal.Funcionalidad2.ColaboracionProcessor;
import com.qitson.proyectoFinal.Funcionalidad2.ColaboracionResponse;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ColaboracionGatewayTest {

    @Test
    public void given_colaboration_when_is_incorrect_then_error(){
        ColaboracionGateway gateway = Mockito.mock(ColaboracionGateway.class);
        ColaboracionProcessor processor = new ColaboracionProcessor(gateway);

        Mockito.when(gateway.requestColaboracion(Mockito.any()))
                .thenReturn(new ColaboracionResponse(ColaboracionResponse.ColaboracionEstado.OK));

        Proyecto proyecto = Data.getDataProyectos().get(Data.getDataProyectos().size()-1);
        proyecto.set_estado(Proyecto.Estado.CERRADO);
        Colaborador colaborador = new Colaborador(Data.getDataProyectos().get(1).get_propietario());
        Aporte aporte = new Aporte("Aplicación de BigData sobre el proyecto");

        assertFalse(processor.realizarSolicitudColaboracion(proyecto, colaborador, aporte));
    }
}