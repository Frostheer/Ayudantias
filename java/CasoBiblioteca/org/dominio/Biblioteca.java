package CasoBiblioteca.org.dominio;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<MaterialBiblioteca> materialEnBiblioteca = new ArrayList<>();


    public void agregarMaterial(MaterialBiblioteca materialBiblioteca){
        materialEnBiblioteca.add(materialBiblioteca);
    }

    public MaterialBiblioteca buscarMaterialSegunTitulo(String titulo){
        for (MaterialBiblioteca materialBiblioteca : materialEnBiblioteca) {
            if(materialBiblioteca.getTitulo().equals(titulo)){
                return materialBiblioteca;
            }
        }
        return null;
    }

    public MaterialBiblioteca buscarMaterialSegunAutor(String autor){
        for (MaterialBiblioteca materialBiblioteca : materialEnBiblioteca) {
            if(materialBiblioteca.getAutor().equals(autor)){
                return materialBiblioteca;
            }
        }
        return null;
    }

//--------------------------------------------------------------------------------------//
    // Investigar respecto al Optional<>
    public Libro buscarLibroSegunISBN(String ISBN){
        //muestra de programacion funcional
        return materialEnBiblioteca.stream()
                .filter(materialBiblioteca -> materialBiblioteca instanceof Libro)
                .map(materialBiblioteca -> (Libro) materialBiblioteca)
                .filter(libro -> ISBN.equals(libro.getISBN()))
                .findFirst()
                .orElse(null);
    }

    public Libro buscarMaterialSegunISSN(String ISSN){
        for (MaterialBiblioteca materialBiblioteca : materialEnBiblioteca) {
            if (materialBiblioteca instanceof Libro libro){
                if(ISSN.equals(libro.getISBN())){
                    return libro;
                }
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------------------//
    public void prestamoMaterialSegunId(String id){
        if(verificarExistencia(id)){
            MaterialBiblioteca materialEncontrado = buscarMaterialSegunId(id);

            if (materialEncontrado != null) {
                materialEncontrado.prestar();
            }
        }
    }

    public void devolverSegunId(String id){
        if(verificarExistencia(id)){
            MaterialBiblioteca materialEncontrado = buscarMaterialSegunId(id);

            if (materialEncontrado != null) {
                materialEncontrado.devolver();
            }
        }
    }

//--------------------------------------------------------------------------------------//
    private boolean verificarExistencia(String id){
        for (MaterialBiblioteca materialBiblioteca :materialEnBiblioteca ) {
            if(materialBiblioteca.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    private MaterialBiblioteca buscarMaterialSegunId(String id){
        for (MaterialBiblioteca materialBiblioteca :materialEnBiblioteca ) {
            if(materialBiblioteca.getId().equals(id)){
                return materialBiblioteca;
            }
        }
        return null;
    }
//--------------------------------------------------------------------------------------//
    //setter y getter implementados para facilidad de las pruebas
    public void setMaterialEnBiblioteca(List<MaterialBiblioteca> materialEnBiblioteca) {
        this.materialEnBiblioteca = materialEnBiblioteca;
    }

    public List<MaterialBiblioteca> getMaterialEnBiblioteca() {
        return materialEnBiblioteca;
    }

    //--------------------------------------------------------------------------------------//

    public void mostrarTodoMaterialBiblioteca(){
        for (MaterialBiblioteca materialBiblioteca : materialEnBiblioteca) {
            System.out.println(materialBiblioteca.toString());
        }
    }


}
