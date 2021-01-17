package com.qitson.proyectoFinal.Funcionalidad1;

import com.qitson.datos.Data;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExternalContentTest {

    @Test
    public void given_a_platform_api_and_user_when_import_project_then_ok(){
        ExternalContent external = Mockito.mock(ExternalContent.class);
        Usuario any_user = Data.getDataProyectos().get(0).get_propietario();
        ArrayList<Proyecto> recomendaciones = new ArrayList<>();
        String EXAMPLE_API = "https://api.bigcommerce.com/stores/%7B%24%24.env.store_hash%7D/v3/catalog/products?_ga=2.247571727.900459152.1610901183-621554821.1610901183";
        Proyecto projectoImportado;
        Mockito.when(external.importaProyecto(EXAMPLE_API, any_user)).thenReturn(new Proyecto("Named in platform", "Project description", "Project area", any_user));
        Proyecto actual = external.importaProyecto(EXAMPLE_API, any_user);
        assertNotNull(actual);
    }
}