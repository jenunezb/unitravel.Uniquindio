package co.edu.uniquindio.unitravel.entidades;

import lombok.*;
import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @ManyToMany(mappedBy = "hoteles")
    private List<Habitacion> habitaciones;


    @ElementCollection
    private List<String> caracteristica;

    @ToString.Exclude
    @OneToMany(mappedBy = "hoteles")
    private List<Foto> fotos;

    @ToString.Exclude
    @OneToMany(mappedBy = "hoteles")
    private List<Comentario> comentarios;

}
