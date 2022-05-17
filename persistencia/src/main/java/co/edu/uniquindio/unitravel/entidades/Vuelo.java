package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private String codigo;

    @Column(length = 200, nullable = false)
    private String aerolinea;

    //Falta FK de Ciudad origen y destino

    @ElementCollection
    @NonNull
    @Column(length = 200)
    private List <String> ReservaSilla;

    public Vuelo(String codigo, String aerolinea, List<String> reservaSilla) {
        this.codigo = codigo;
        this.aerolinea = aerolinea;
        ReservaSilla = reservaSilla;
    }

}
