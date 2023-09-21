package foro.Controller;

import foro.DTO.DatosActualizarTopico;
import foro.DTO.DatosListadoTopico;
import foro.DTO.DatosRegistroTopico;
import foro.DTO.DatosRespuestaTopico;
import foro.Modelo.Curso;
import foro.Modelo.Topico;
import foro.Modelo.Usuario;
import foro.Repository.CursoRepository;
import foro.Repository.TopicoRepository;
import foro.Repository.UsuarioRepository;
import foro.Service.TopicoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoService topicoService;

    //crear un nuevo topico

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
       Topico  topico = topicoService.registrarTopico(datosRegistroTopico);

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(topico);
    }


    //Mostrar todos los topicos creados
    @GetMapping
    public ResponseEntity<Page<Topico>> listarTopicos(@PageableDefault(size = 3) Pageable paginacion){

        return ResponseEntity.ok(topicoService.listarTopicos(paginacion));

    }

    //usar paginacion
    @GetMapping("/listado")
    public ResponseEntity<List<DatosListadoTopico>> obtenerTodosLosTopicos() {
        List<DatosListadoTopico> topicos = topicoService.listarDatosListadoTipicos();
        return ResponseEntity.ok(topicos);
    }

    //Mostrar un topico especifico
    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopico(@PathVariable Long id){
        Topico topico = topicoService.listarTopico(id);
        return ResponseEntity.ok(topico);
    }

    //Eliminar topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }


    //Actualizar un topico
    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizarTopico){

        Topico topico = topicoService.actualizarTopico(id, datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),topico.getMensaje(),
                topico.getFechaCreacion(),topico.getStatus()));
    }


}
