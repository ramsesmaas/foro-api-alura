package foro.DTO;

import foro.Modelo.StatusTopico;
import lombok.Getter;

import java.time.LocalDateTime;


public record DatosRegistroTopico(

        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,

        long autor_id,  //autorId

        long curso_id   //cursoId
        ) {


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
                return autor_id;
        }


        public Long getCurso_id() {
                return curso_id;
        }
}
