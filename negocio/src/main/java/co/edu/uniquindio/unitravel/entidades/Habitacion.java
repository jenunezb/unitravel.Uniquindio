package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Habitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    private double precio;

    private int capacidad;

    @ElementCollection
    @Column(length = 100, nullable = false)
    private List<Cama> cama;

    @ElementCollection
    private List<String> caracteristica;

    @ManyToMany
    private List<Hotel> hoteles;

    @ToString.Exclude
    @OneToMany(mappedBy = "habitaciones")
    private List<Foto> fotos;

}
