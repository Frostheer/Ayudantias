package CasoBiblioteca.org.vistas;

import CasoBiblioteca.org.dominio.Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaView extends JFrame implements ActionListener {

    private Biblioteca biblioteca;
    private JButton prestarMaterial;
    private JButton devolverMaterial;
    private JButton buscarMaterial;
    private JButton agregarMaterial;

    public BibliotecaView(Biblioteca biblioteca){

        this.biblioteca = biblioteca;

        setTitle("Biblioteca");
        setLayout(new FlowLayout());
        setvisibilidad(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        añadirComponentes();
    }

    private void setvisibilidad(boolean visible){
        setVisible(visible);
    }


    private void añadirComponentes(){

        prestarMaterial = new JButton("Prestar Material");
        devolverMaterial = new JButton("Devolver Material");
        buscarMaterial = new JButton("Buscar Material");
        agregarMaterial = new JButton("Agregar Material Biblioteca");

        prestarMaterial.addActionListener(this);
        devolverMaterial.addActionListener(this);
        buscarMaterial.addActionListener(this);
        agregarMaterial.addActionListener(this);

        add(prestarMaterial);
        add(devolverMaterial);
        add(buscarMaterial);
        add(agregarMaterial);

        pack();

        setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent evento) {

        if(evento.getSource().equals(prestarMaterial)){
            new PrestamoView();
            setvisibilidad(false);
        }
        if(evento.getSource().equals(devolverMaterial)){
            //DevolucionView
            setvisibilidad(false);
        }
        if(evento.getSource().equals(buscarMaterial)){
            //BusquedaView
            setvisibilidad(false);
        }
        if(evento.getSource().equals(agregarMaterial)){
            new AgregarMaterialView(biblioteca);
            setvisibilidad(false);
        }
    }
}


