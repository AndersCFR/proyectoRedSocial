package com.qitson.proyectoFinal.Funcionalidad1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validación {

    private static final String REGEX_CORREO = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+$";

    public static void validarNumeroCaracteres(String contenido, int numMaximoCaracteres) throws Exception {
        if(contenido.length() >= numMaximoCaracteres) {
            throw new Exception("Ha superado el límite de caracteres permitidos (" + numMaximoCaracteres + ")");
        }
    }

    public static boolean validarCorreoElectronico(String correoIngresado){
        Pattern pattern = Pattern.compile(REGEX_CORREO, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(correoIngresado);
        boolean matchFound = matcher.find();
        return matchFound;
    }

}
