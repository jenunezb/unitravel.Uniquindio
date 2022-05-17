package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cliente extends Persona implements Serializable {

    @OneToMany(mappedBy = "clientes")
    private List<Comentario> comentarios;

    public Cliente(String cedula, String nombre, String email, Map<String, String> telefono, Ciudad ciudad, List<Comentario> comentarios) {
        super(cedula, nombre, email, telefono, ciudad);
        this.comentarios = comentarios;
    }
}