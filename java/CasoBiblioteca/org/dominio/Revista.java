package CasoBiblioteca.org.dominio;

public class Revista extends MaterialBiblioteca{

    private String ISSN;
    private String numero;

    public Revista(String id, String titulo, String autor, String ISSN, String numero) {
        super(id, titulo, autor);
        this.ISSN = ISSN;
        this.numero = numero;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getNumero() {
        return numero;
    }
}
