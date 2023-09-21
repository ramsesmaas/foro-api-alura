package foro.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import foro.DTO.DatosListadoUsuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name ="usuarios")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String email;

    private String contraseña;

    //relacion con respuesta
    @OneToMany(mappedBy="autor" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Respuesta> respuestas;  //set?

    //relcion con topicos
    @OneToMany(mappedBy="autor" , fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"autor"})
    private List<Topico> topicos;

    public Usuario(DatosListadoUsuario datosListadoUsuario){
        this.nombre = datosListadoUsuario.nombre();
        this.email = datosListadoUsuario.email();
        this.contraseña = datosListadoUsuario.contraseña();
    }
}
