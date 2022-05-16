package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Hotel implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @Column(length = 200, nullable = false)
    private String nombre;

    @Column(length = 200, nullable = false)
    private String direccion;

    @Column(length = 20, nullable = false)
    private String telefono;

    @Column( nullable = false)
    @Min(0)
    @Max(5)
    private int estrellas;

    //Falta FK ciudad


    public Hotel(String codigo, String nombre, String direccion, String telefono, int estrellas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrellas = estrellas;
    }
}
