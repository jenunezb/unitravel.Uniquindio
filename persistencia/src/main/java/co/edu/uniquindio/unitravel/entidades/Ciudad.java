package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ciudad implements Serializable {

    @OneToMany(mappedBy = "ciudad")
    private List<Persona> personas;

    @OneToMany(mappedBy = "ciudad")
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Vuelo> vuelosOrigen;

    @OneToMany(mappedBy = "ciudadDestino")
    private List<Vuelo> vuelosDestino;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private int codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    public Ciudad(List<Persona> personas, int codigo, @NonNull String nombre) {
        this.personas = personas;
        this.codigo = codigo;
        this.nombre = nombre;
    }

}
