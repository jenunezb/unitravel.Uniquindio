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
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;
    @Column(length = 200, nullable = false)
    private int posicion;
    @ElementCollection
    @NonNull
    @Column(length = 100)
    private List <Double> clase;

    @ManyToMany
    private List<Vuelo> vuelos;


}
