package co.edu.uniquindio.unitravel.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AdminHotel extends Persona implements Serializable {
    public AdminHotel(String cedula, String nombre, String email, Map<String, String> telefono, Ciudad ciudad) {
        super(cedula, nombre, email, telefono, ciudad);
    }
}
