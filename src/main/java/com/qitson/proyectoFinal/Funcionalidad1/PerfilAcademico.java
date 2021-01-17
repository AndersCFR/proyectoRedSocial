package com.qitson.proyectoFinal.Funcionalidad1;

public class PerfilAcademico {
    private String _universidad;
    private String _nombreFacultad;
    private String _carreraUniversitaria;

    public PerfilAcademico(String universidad, String nombreFacultad, String carreraUniversitaria) {
        this._universidad = universidad;
        this._nombreFacultad = "Facultad de "+nombreFacultad;
        this._carreraUniversitaria = carreraUniversitaria;
    }

    public String get_universidad() {
        return _universidad;
    }

    public String get_carreraUniversitaria() {
        return _carreraUniversitaria;
    }

}
