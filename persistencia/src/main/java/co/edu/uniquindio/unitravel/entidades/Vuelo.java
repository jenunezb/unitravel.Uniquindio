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
    @JoinColumn(nullable = false)
    private Ciudad ciudadDestino; //Ciudad de destino
    @ElementCollection

    @Column(length = 200)
    private List <Integer> ReservaSilla;

    public Vuelo(String codigo, List<String> aerolinea, Ciudad ciudadOrigen, Ciudad ciudadDestino, List<Integer> reservaSilla) {
        this.codigo = codigo;
        this.aerolinea = aerolinea;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        ReservaSilla = reservaSilla;
    }
}
