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

    @ManyToOne
    @NonNull
    private Hotel hotel;
    
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @NonNull
    private double precio;

    @Min(1)
    @NonNull
    private int capacidad;

    @ElementCollection
    @Column(length = 100, nullable = false)
    private List<String> cama;

}
