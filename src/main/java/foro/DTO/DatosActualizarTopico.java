package foro.DTO;

import foro.Modelo.StatusTopico;
import foro.Modelo.Topico;

import java.time.LocalDateTime;

public record DatosActualizarTopico(Long id,

                                    String titulo,

                                    String mensaje,

                                    LocalDateTime fechaCreacion,

                                    StatusTopico status,

                                    Long autorId,  //autorId

                                    Long cursoId) {


    public String getTitulo() {
        return titulo;
    }


    public String getMensaje() {
        return mensaje;
    }


    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }


    public StatusTopico getStatus() {
        return status;
    }


    public Long getAutor_id() {
        return autorId;
    }


    public Long getCurso_id() {
        return cursoId;
    }
}
