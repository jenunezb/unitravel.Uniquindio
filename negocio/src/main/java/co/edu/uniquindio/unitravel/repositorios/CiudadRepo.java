package co.edu.uniquindio.unitravel.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.uniquindio.unitravel.entidades.Ciudad;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad,Integer>{

}
