package foro.DTO;

import foro.Modelo.Respuesta;
import foro.Modelo.StatusTopico;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListadoTopico (
        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fechaCreacion,

        StatusTopico status,

        String nombreAutor,  //autorId

        String nombreCurso,   //cursoId

        List<Respuesta> respuestas){

       // public DatosListadoTopico(Topico topico){
               // this(topico.getId(), topico.getMensaje(), topico.getFechaCreacion(),
                 //       topico.getStatus(),);
        //}
}
