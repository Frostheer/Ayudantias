package CasoBiblioteca.org.launcher;

import CasoBiblioteca.org.dominio.Biblioteca;
import CasoBiblioteca.org.vistas.BibliotecaView;


public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        new BibliotecaView(biblioteca);

    }
}