package CasoBiblioteca.org.dominio;


public class MaterialBiblioteca implements Caso.Prestable {

    private String id;
    private boolean prestado;
    private String titulo;
    private String autor;

    public MaterialBiblioteca(String id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public void prestar() {
        prestado = true;
    }

    @Override
    public void devolver() {
        prestado = false;
    }

    @Override
    public String toString() {
        return "MaterialBiblioteca{" +
                "id='" + id + '\'' +
                ", prestado=" + prestado +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
