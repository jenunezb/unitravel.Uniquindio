package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
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

    //Falta poner minimos y máximos en longitud y decimales aceptados segun la moneda local
    @NonNull
    private double precio;

    @Min(1)
    @NonNull
    private int capacidad;

    @ElementCollection
    @NonNull
    private List<String> cama;

    //FK con Hotel

}
