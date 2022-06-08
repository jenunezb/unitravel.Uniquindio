package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reserva implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @ManyToOne
    private Vuelo vuelo;

    @Column( nullable = false)
    private LocalDateTime fechaReserva;

    @Column( nullable = false)
    private LocalDateTime fechaInicio;

    @Column( nullable = false)
    private  LocalDateTime fechaFin;

    @Column( nullable = false)
    private double precioTotal;

    @NonNull
    @ElementCollection
    private List<String> estado;

    @Column( nullable = false)
    private int cantidadPersonas;

    //Muchos a muchos con habitaciones y sillas
}
