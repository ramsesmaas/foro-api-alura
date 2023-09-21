package foro.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Table(name ="respuestas")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    //relacion con usuario autor
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario autor;

    //relacion con topico
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="topico_id", nullable=false)
    private Topico topico;

    private Boolean solucion = false;
}
