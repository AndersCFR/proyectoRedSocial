package com.qitson.proyectoFinal.Funcionalidad2;

public class ColaboracionResponse {
    public enum ColaboracionEstado {
        OK, ERROR
    }
    public ColaboracionEstado status;

    public ColaboracionResponse(ColaboracionEstado status) {
        this.status = status;
    }

    public ColaboracionEstado getStatus() {
        return status;
    }

    public void setStatus(ColaboracionEstado status) {
        this.status = status;
    }
}
