package foro.DTO;

import foro.Modelo.Usuario;

public record DatosListadoUsuario(String nombre, String email, String contraseña) {

    public DatosListadoUsuario(Usuario usuario){
        this(usuario.getNombre(), usuario.getEmail(), usuario.getContraseña());
    }
}
