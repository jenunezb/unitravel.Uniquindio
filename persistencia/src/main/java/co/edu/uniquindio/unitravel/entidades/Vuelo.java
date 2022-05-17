package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Vuelo implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo; //Código de Vuelos autoincrementable

    @ElementCollection
    @Column(length = 200, nullable = false)
    private List <String> aerolinea; //Creo una lista de Aerolineas sin importar el resto de la información

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudadOrigen; //Ciudad de origen

    @ManyToOne
    private Ciudad ciudadDestino; //Ciudad de destino;

    @ToString.Exclude
    @OneToMany(mappedBy = "vuelo")
    private List<Reserva> reservas;

    @ToString.Exclude
    @ManyToMany(mappedBy = "vuelos")
    private List<Silla> sillas;

}
