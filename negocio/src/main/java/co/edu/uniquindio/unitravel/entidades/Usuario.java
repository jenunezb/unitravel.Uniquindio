package co.edu.uniquindio.unitravel.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Usuario extends Persona implements Serializable {
    @ToString.Exclude
    @OneToMany(mappedBy = "usuarios")
    private List<Comentario> comentarios;

    public Usuario(String cedula, String nombre, String email, Map<String, String> telefono, Ciudad ciudad, String password, List<Comentario> comentarios) {
        super(cedula, nombre, email, telefono, ciudad, password);
        this.comentarios = comentarios;
    }
}