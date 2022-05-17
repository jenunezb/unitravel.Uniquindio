package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {
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

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

}
