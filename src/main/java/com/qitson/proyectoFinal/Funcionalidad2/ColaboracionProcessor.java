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
        ColaboracionResponse res = gateway.requestColaboracion(new ColaboracionRequest(proyecto, colaborador, aporte));
        BuscadorProyectos buscadorProyectos = new BuscadorProyectos();
        return verificarCondicionesResponse(proyecto, colaborador, aporte, res, buscadorProyectos);
    }

    private boolean verificarCondicionesResponse(Proyecto proyecto, Colaborador colaborador, Aporte aporte, ColaboracionResponse res, BuscadorProyectos buscadorProyectos) {
        boolean responseEsOk = res.getStatus() == ColaboracionResponse.ColaboracionEstado.OK;
        boolean existenciaProyecto = buscadorProyectos.verificarExistenciaProyecto(Data.getDataProyectos(), proyecto);
        boolean disponibilidadProyecto = proyecto.get_estado() == Proyecto.Estado.BUSCANDO_COLABORACION;
        if(responseEsOk && existenciaProyecto && disponibilidadProyecto){
            crearSolicitud(proyecto, colaborador, aporte);
            return true;
        }
        return false;
    }

    private void crearSolicitud(Proyecto proyecto, Colaborador colaborador, Aporte aporte){
        Data.solicitudes.add(new ColaboracionRequest(proyecto, colaborador, aporte));
    }
}



