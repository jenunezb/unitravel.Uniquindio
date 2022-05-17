package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

        @Id
        @EqualsAndHashCode.Include
        @Column(length = 10)
        private String cedula;
        @Column(length = 200, nullable = false)
        private String nombre;

        @Column (length = 200,nullable = false, unique = true)
        private String email;
        @ElementCollection
        private Map<String, String> telefono;

    public Persona(@NonNull Ciudad ciudad, String cedula, String nombre, String email, Map<String, String> telefono) {
        this.ciudad = ciudad;
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
}
