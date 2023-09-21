package foro.DTO;

import foro.Modelo.StatusTopico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fechaCreacion,

        StatusTopico status


) {


    public Long getId() {
        return id;
    }

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



}
