package foro.Service;

import foro.DTO.DatosActualizarTopico;
import foro.DTO.DatosListadoTopico;
import foro.DTO.DatosRegistroTopico;
import foro.Modelo.Curso;
import foro.Modelo.Topico;
import foro.Modelo.Usuario;
import foro.Repository.CursoRepository;
import foro.Repository.TopicoRepository;
import foro.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public Page<Topico> listarTopicos(Pageable page){

        return topicoRepository.findAll(page);
    }

    public List<DatosListadoTopico> listarDatosListadoTipicos(){
        //buscar topicos
        List<Topico> topicos = topicoRepository.findAll();

        return topicos.stream().map(topico -> {
            Usuario autor = usuarioRepository.findById(topico.getAutor().getId()).orElse(null);
            Curso curso = cursoRepository.findById(topico.getCurso().getId()).orElse(null);
            //cargar las respuestas de cada topico
            topico.getRespuestas().size();

            return new DatosListadoTopico(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getStatus(),
                    (autor != null) ? autor.getNombre() : null,
                    (curso != null) ? curso.getNombre() : null,
                    topico.getRespuestas()
            );
        }).collect(Collectors.toList());
    }


    public Topico registrarTopico(DatosRegistroTopico datosRegistroTopico){
        Topico topico = new Topico();

        topico.setTitulo(datosRegistroTopico.getTitulo());
        topico.setMensaje(datosRegistroTopico.getMensaje());
        topico.setFechaCreacion(datosRegistroTopico.getFechaCreacion());
        topico.setStatus(datosRegistroTopico.getStatus());

        //buscar curso por su id
        Usuario autor = usuarioRepository.findById(datosRegistroTopico.getAutor_id())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el usuario con ID " + datosRegistroTopico.getAutor_id()));
        //buscar autor por su id
        Curso curso = cursoRepository.findById(datosRegistroTopico.getCurso_id())
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el curso con ID " + datosRegistroTopico.curso_id()));

        topico.setAutor(autor);
        topico.setCurso(curso);

        topicoRepository.save(topico);

        return topico;
    }

    public Topico actualizarTopico(long topicoId,DatosActualizarTopico datosActualizarTopico) {
        //buscar topico a actualizar
        //Topico topico = topicoRepository.findById(topicoId);
        Topico topico = topicoRepository.findById(topicoId)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el tópico con ID " + topicoId));

        //fijar cambios
        // Actualizar los campos del tópico con los datos del DTO
        if (datosActualizarTopico.getTitulo() != null) {
            topico.setTitulo(datosActualizarTopico.getTitulo());

        }
        if (datosActualizarTopico.getMensaje() != null) {
            topico.setMensaje(datosActualizarTopico.getMensaje());
        }
        if (datosActualizarTopico.getStatus() != null) {
            topico.setStatus(datosActualizarTopico.getStatus());
        }

        // Actualizar el autor si se proporciona el ID del nuevo autor
        if (datosActualizarTopico.getAutor_id() != null) {
            Usuario nuevoAutor = usuarioRepository.findById(datosActualizarTopico.getAutor_id())
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró el usuario con ID " + datosActualizarTopico.getAutor_id()));
            topico.setAutor(nuevoAutor);
        }

        // Actualizar el curso si se proporciona el ID del nuevo curso
        if (datosActualizarTopico.getCurso_id() != null) {
            Curso nuevoCurso = cursoRepository.findById(datosActualizarTopico.getCurso_id())
                    .orElseThrow(() -> new EntityNotFoundException("No se encontró el curso con ID " + datosActualizarTopico.getCurso_id()));
            topico.setCurso(nuevoCurso);
        }

        // Guardar el tópico actualizado en la base de datos
        topicoRepository.save(topico);
        return topico;
    }

    public void eliminarTopico(Long id){
        Topico topico = topicoRepository.findById(id).get();
        if(topico != null){
            topicoRepository.delete(topico);
        }else {
            throw new EntityNotFoundException("No se elimino el topico");
        }

    }

    public Topico listarTopico(Long id){
        Topico topico = topicoRepository.findById(id).get();
        return  topico;
    }

}
