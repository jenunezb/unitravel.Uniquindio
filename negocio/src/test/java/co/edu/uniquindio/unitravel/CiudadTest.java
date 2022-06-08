package co.edu.uniquindio.unitravel;


import co.edu.uniquindio.unitravel.entidades.Ciudad;
import co.edu.uniquindio.unitravel.repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void registrarCiudadTest(){
        Ciudad ciudad = new Ciudad(6, "Tolima");
        Ciudad ciudadGuardada = ciudadRepo.save(ciudad);

        Assertions.assertNotNull(ciudadGuardada);
        //System.out.println(ciudadGuardada);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void modificarCiudadTest(){
        //Busco la ciudad que quiero modificar
        Ciudad modificar = ciudadRepo.findById(2).orElse(null);

        //Inserto el nombre deseado y modifico
        modificar.setNombre("Bucaramanga");
        ciudadRepo.save(modificar);

        //Realizo la busqueda para verificar que sí quedó guardado
        Ciudad buscado = ciudadRepo.findById(2).orElse(null);
        Assertions.assertEquals("Bucaramanga",buscado.getNombre());
        System.out.println(buscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCiudadTest(){
        //Busco la ciudad que quiero modificar
        Ciudad modificar = ciudadRepo.findById(2).orElse(null);

        //Elimino la ciudad que busqué
        ciudadRepo.delete(modificar);

        //Por último, verificamos que si haya quedado borrado
        Ciudad buscado = ciudadRepo.findById(2).orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCiudades(){
        List<Ciudad> ciudades = ciudadRepo.findAll();
        System.out.println(ciudades);
    }
}


