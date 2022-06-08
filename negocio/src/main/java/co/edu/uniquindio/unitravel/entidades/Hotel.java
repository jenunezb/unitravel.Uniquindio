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
@ToString
public class Hotel implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100)
    private Integer codigo;

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

    @ManyToOne
    @JoinColumn(nullable = false)
    private AdminHotel adminHotel;

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

    //Agregar el admin hotel

    public Hotel(Integer codigo, String nombre, String direccion, String telefono, int estrellas, Ciudad ciudad, AdminHotel adminHotel) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrellas = estrellas;
        this.ciudad = ciudad;
        this.adminHotel = adminHotel;
    }
}