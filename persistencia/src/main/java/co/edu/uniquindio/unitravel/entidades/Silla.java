package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

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
    private List <Integer> clase;

    public Silla(String codigo, int posicion, @NonNull List<Integer> clase) {
        this.codigo = codigo;
        this.posicion = posicion;
        this.clase = clase;
    }

    //Falta codigo del vuelo y codigo de la clase
}
