package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Hotel implements Serializable {
    @OneToMany(mappedBy = "hotel")
    @NonNull
    private List<Habitacion> habitaciones;

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


    public Hotel(List<Habitacion> habitaciones, String codigo, String nombre, String direccion, String telefono, int estrellas) {
        this.habitaciones = habitaciones;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrellas = estrellas;
    }

}
