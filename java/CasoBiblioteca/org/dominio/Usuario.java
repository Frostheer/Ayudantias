package CasoBiblioteca.org.dominio;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String idUsuario;
    String nombre;
    String email;
    List<MaterialBiblioteca> librosPedidos;

    public Usuario(String idUsuario, String nombre, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        librosPedidos = new ArrayList<>();
    }

}
