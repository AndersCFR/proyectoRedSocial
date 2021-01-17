package com.qitson.proyectoFinal.Funcionalidad2;
import com.qitson.datos.Data;
import com.qitson.proyectoFinal.Funcionalidad1.Colaborador;
import com.qitson.proyectoFinal.Funcionalidad1.Aporte;
import com.qitson.proyectoFinal.Funcionalidad1.Proyecto;


public class ColaboracionProcessor {
    ColaboracionGateway gateway;

    public ColaboracionProcessor(ColaboracionGateway gateway) {
        this.gateway = gateway;
    }

    public boolean realizarSolicitudColaboracion(Proyecto proyecto, Colaborador colaborador, Aporte aporte){
        ColaboracionResponse res = gateway.requestColaboracion(
                new ColaboracionRequest(proyecto, colaborador, aporte)
        );
        BuscadorProyectos b = new BuscadorProyectos();
        if(res.getStatus() == ColaboracionResponse.ColaboracionEstado.OK
                && b.verificarExistenciaProyecto(Data.getDataProyectos(), proyecto)
                && proyecto.get_estado() == Proyecto.Estado.BUSCANDO_COLABORACION){
            Data.solicitudes.add(new ColaboracionRequest(proyecto, colaborador, aporte));
            return true;
        }
        return false;
    }
}



