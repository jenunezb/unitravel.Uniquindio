package co.edu.uniquindio.unitravel.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniquindio.unitravel.entidades.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {

}

