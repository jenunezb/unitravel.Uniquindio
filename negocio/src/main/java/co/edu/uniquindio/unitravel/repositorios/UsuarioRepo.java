package co.edu.uniquindio.unitravel.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {
    List<Usuario> findAllByNombre(String nombre);

    @Query("select u from Usuario u where u.email=:email and u.password=:password")//Buscar usuario por correo y contraseña
    Optional<Usuario> comprobarAutenticacion(String email, String password);


    Optional<Usuario>findByEmailAndPassword(String email, String password); //Buscar usuario por correo y contraseña


}

