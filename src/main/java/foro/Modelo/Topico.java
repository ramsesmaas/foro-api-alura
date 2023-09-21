package foro.Modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import foro.DTO.DatosActualizarTopico;
import foro.DTO.DatosRegistroTopico;
import foro.DTO.DatosRespuestaTopico;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name ="topicos")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Column(name = "Fecha_Creacion")  //fecha_creacion mysql bien,
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;

    //relacion con usuario
    @JsonIgnoreProperties(value = {"topicos"})
    @ManyToOne
    @JoinColumn(name="autor_id", nullable = false)
    private Usuario autor;

    //relacion con respuesta
    @OneToMany(mappedBy="topico", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Respuesta> respuestas;

    //relacion con curso
    @JsonIgnoreProperties(value = {"topicos"})  //?
    @ManyToOne
    @JoinColumn(name="curso_id", nullable = false)
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fechaCreacion = datosRegistroTopico.fechaCreacion();
        this.status = datosRegistroTopico.status();

    }

    public Topico(DatosActualizarTopico datosActualizarTopico){
        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.getMensaje();
        this.fechaCreacion = datosActualizarTopico.fechaCreacion();
        this.status = datosActualizarTopico.status();
    }

    public Topico(DatosRespuestaTopico datosRespuestaTopico){
        this.titulo = datosRespuestaTopico.titulo();
        this.mensaje = datosRespuestaTopico.getMensaje();
        this.fechaCreacion = datosRespuestaTopico.fechaCreacion();
        this.status = datosRespuestaTopico.status();
    }
}
