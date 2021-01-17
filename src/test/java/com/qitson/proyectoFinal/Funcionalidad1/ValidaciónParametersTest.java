package com.qitson.proyectoFinal.Funcionalidad1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(value = Parameterized.class)
public class ValidaciónParametersTest {

    private String correoElectrónico;

    public ValidaciónParametersTest(String correoElectrónico){
        this.correoElectrónico = correoElectrónico;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{"lqq@sas"});
        objects.add(new Object[]{"@ibm.com.maria"});
        objects.add(new Object[]{"\" or \"\"=\""}); // verificar que no permitiría un sql injection
        objects.add(new Object[]{"alejandrollanganate.gmail.com"});
        return objects;
    }

    @Test
    public void given_a_incorrect_mail_when_verify_mails_format_then_incorrect(){
        boolean isCorrect = Validación.validarCorreoElectronico(correoElectrónico);
        assertFalse(isCorrect);
     }

}