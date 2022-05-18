package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Administrador;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    public void registrarAdmin(){
        Administrador admin = new Administrador("5","pablo","administrador@unitravel.co",null,null,"123");
        Administrador adminGuardado = administradorRepo.save(admin);

        Assertions.assertNotNull(adminGuardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarAdminTest(){
        Administrador buscado = administradorRepo.findById("2").orElse(null);
        System.out.println(buscado);

        administradorRepo.delete(buscado);

        //Por último, verificamos que si haya quedado borrado
        Administrador borrado = administradorRepo.findById("2").orElse(null);
        Assertions.assertNull(borrado);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void modificarAdmin(){
        Administrador buscado = administradorRepo.findById("2").orElse(null);
        System.out.println(buscado);

        buscado.setNombre("Luz");

        administradorRepo.save(buscado);

        Administrador modificado = administradorRepo.findById("2").orElse(null);
        System.out.println(modificado);

        Assertions.assertEquals("Luz",modificado.getNombre());
    }
}
