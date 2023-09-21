package foro.Controller;

import foro.DTO.DatosListadoUsuario;
import foro.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<DatosListadoUsuario> listadoUsuario(){
        return usuarioRepository.findAll().stream().map(DatosListadoUsuario::new).toList();

    }

}
