package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Usuario;
import co.edu.uniquindio.unitravel.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void registrarUsuarioTest(){
        Usuario u = new Usuario("1", "Pepito","pepito@gmail.com",null,null,"1234");
       Usuario usuarioGuardado = usuarioRepo.save(u);

        Assertions.assertNotNull(usuarioGuardado);
    }

    @Test
    public void eliminarUsuarioTest(){

        //Creamos un usuario
        Usuario u = new Usuario("1", "Pepito","pepito@gmail.com",null,null,"1234");
        Usuario usuarioGuardado = usuarioRepo.save(u);

        //Luego lo eliminamos
        usuarioRepo.delete(usuarioGuardado);

        //Por último, verificamos que si haya quedado borrado
        Usuario buscado = usuarioRepo.findById("1").orElse(null);
        Assertions.assertNull(buscado);

    }

    @Test
    public void modificarUsuarioTest(){
        //Creamos un usuario
        Usuario u = new Usuario("1", "Pepito","pepito@gmail.com",null,null,"1234");
        Usuario usuarioGuardado = usuarioRepo.save(u);
        usuarioGuardado.setPassword("123");

        //Por último, verificamos que si haya quedado modificado
        Usuario buscado = usuarioRepo.findById("1").orElse(null);
        Assertions.assertEquals("123",buscado.getPassword());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuariosPorNombre(){
        List<Usuario> usuarios = usuarioRepo.findAllByNombre("Esteban");
        System.out.println(usuarios);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarDatosAutenticacion(){
         Optional<Usuario>usuario=usuarioRepo.findByEmailAndPassword("esteban@email.com","123" );
        System.out.println(usuario.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarTodosLosUsuarios(){
        List<Usuario> usuarios=usuarioRepo.findAll(Sort.by("nombre"));
        usuarios.forEach(System.out::println);
    }
}