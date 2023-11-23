package CasoBiblioteca.org.vistas;

import CasoBiblioteca.org.dominio.Biblioteca;
import CasoBiblioteca.org.dominio.Libro;
import CasoBiblioteca.org.dominio.Revista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public class AgregarMaterialView extends JFrame implements ActionListener, ItemListener {

    private Biblioteca biblioteca;


    private JComboBox tipoMaterial;
    private String materialSeleccionado;
    private JLabel tituloMaterial;
    private JTextField textFieldTituloMaterial;
    private JLabel autorMaterial;
    private JTextField textFieldAutorMaterial;
    private JLabel ISSNRevista;
    private JTextField textFieldISSNRevista;
    private JLabel numeroRevista;
    private JTextField textFieldNumeroRevista;
    private JLabel ISBNLibro;
    private JTextField textFieldISBNLibro;
    private JLabel edicionLibro;
    private JTextField textFieldEdicionLibro;
    private JButton buttonEnviar;

    public AgregarMaterialView(Biblioteca biblioteca){

        this.biblioteca = biblioteca;

        setTitle("Agregar Material Biblioteca");
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        añadirComponentesIniciales();
        añadirJComboBox();

        setLocationRelativeTo(null);

    }

    private void añadirButtonEnviar(){

        buttonEnviar = new JButton("Enviar");

        buttonEnviar.addActionListener(this);

        add(buttonEnviar);

        pack();
    }
    private void añadirComponentesIniciales(){

        tituloMaterial = new JLabel("Titulo material");
        textFieldTituloMaterial = new JTextField(10);

        add(tituloMaterial);
        add(textFieldTituloMaterial);

        autorMaterial = new JLabel("Autor Material");
        textFieldAutorMaterial = new JTextField(10);

        add(autorMaterial);
        add(textFieldAutorMaterial);

        pack();


    }
    private void añadirJComboBox(){

        tipoMaterial = new JComboBox();
        tipoMaterial.setBounds(10,10,80,20);

        add(tipoMaterial);

        tipoMaterial.addItem("");
        tipoMaterial.addItem("Libro");
        tipoMaterial.addItem("Revista");

        tipoMaterial.addItemListener(this);

        pack();

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if(evento.getSource().equals(buttonEnviar) && Objects.equals(materialSeleccionado, "Libro")){

            String idNuevoLibro = "" + biblioteca.getMaterialEnBiblioteca().size() +1;
            String titulo = textFieldTituloMaterial.getText();
            String autor = textFieldAutorMaterial.getText();
            String ISBN = textFieldISBNLibro.getText();
            String edicion = textFieldEdicionLibro.getText();

            biblioteca.agregarMaterial(new Libro(idNuevoLibro,titulo,autor,ISBN,edicion));

            biblioteca.mostrarTodoMaterialBiblioteca();


        }


        if(evento.getSource().equals(buttonEnviar) && Objects.equals(materialSeleccionado, "Revista")){

            String idNuevaRevista = "" + biblioteca.getMaterialEnBiblioteca().size() +1;
            String titulo = textFieldTituloMaterial.getText();
            String autor = textFieldAutorMaterial.getText();
            String ISSN = textFieldISSNRevista.getText();
            String numero = textFieldNumeroRevista.getText();

            biblioteca.agregarMaterial(new Revista(idNuevaRevista,titulo,autor,ISSN,numero));

            biblioteca.mostrarTodoMaterialBiblioteca();

        }

    }

    @Override
    public void itemStateChanged(ItemEvent evento) {
        if(evento.getStateChange() == ItemEvent.SELECTED){
            if(evento.getSource().equals(tipoMaterial)){
                materialSeleccionado = tipoMaterial.getSelectedItem().toString();

                if(Objects.equals(materialSeleccionado, "Libro")){
                    añadirComponentesLibro();
                }else {
                    añadirComponentesRevista();
                }
            }
        }
    }

    private void añadirComponentesRevista(){
        ISSNRevista = new JLabel("ISSN revista");
        textFieldISSNRevista = new JTextField(10);

        add(ISSNRevista);
        add(textFieldISSNRevista);

        numeroRevista = new JLabel("numero revista");
        textFieldNumeroRevista = new JTextField(10);

        add(numeroRevista);
        add(textFieldNumeroRevista);

        añadirButtonEnviar();

        pack();

    }

    private void añadirComponentesLibro(){

        ISBNLibro = new JLabel("ISBN libro");
        textFieldISBNLibro = new JTextField(10);

        add(ISBNLibro);
        add(textFieldISBNLibro);

        edicionLibro = new JLabel("edicion libro");
        textFieldEdicionLibro = new JTextField(10);

        add(edicionLibro);
        add(textFieldEdicionLibro);

        añadirButtonEnviar();

        pack();
    }


}
