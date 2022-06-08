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
@ToString
public class Ciudad implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudad")
    private List<Hotel> hoteles;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Vuelo> vuelosOrigen;

    @ToString.Exclude
    @OneToMany(mappedBy = "ciudadDestino")
    private List<Vuelo> vuelosDestino;

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100)
    private int codigo;

    @Column(length = 100, nullable = false)
    private String nombre;


    public Ciudad(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}
