package foro.Modelo;

public class TopicoOriginal {

    /*
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
   /@JsonIgnore

    @ManyToOne
    @JoinColumn(name="autor_id", nullable=false)
    private Usuario autor;

    //relacion con respuesta
    @OneToMany(mappedBy="topico")
    private List<Respuesta> respuestas;

    //relacion con curso
    @JsonIgnore  //?

    @ManyToOne
    @JoinColumn(name="curso_id", nullable=false)
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



     */

}
