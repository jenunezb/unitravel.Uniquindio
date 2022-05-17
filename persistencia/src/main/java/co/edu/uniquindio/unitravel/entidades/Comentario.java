package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comentario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String codigo;

    @NonNull
    private String comentario;

    @NonNull
    @Min(0)
    @Max(5)
    private int calificacion;

    @NonNull
    private LocalDateTime fecha;

    @ManyToOne
    private Hotel hoteles;

    @ManyToOne
    private Usuario usuarios;
}
