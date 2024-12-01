package org.example;

import javax.swing.*;
import java.awt.*;

public class VentanaFinal {

    private JTextArea areaTexto;
    private JLabel imagen;
    private ImageIcon rutaImagen;

    private JDialog marco;
    private JPanel panelPrincipal;

    private JButton botonSalir;
    private int condicion;
    private Personaje pj;

    public static final int VICTORIA = 0;
    public static final int DERROTA = 1;

    public VentanaFinal(int condicion, Personaje pj) {
        marco = new JDialog();
        panelPrincipal = new JPanel(new BorderLayout());

        areaTexto = new JTextArea();
        botonSalir = new JButton("Finalizar");

        this.condicion = condicion;

        if (condicion == VICTORIA) rutaImagen = new ImageIcon("src/SPRITES/victoria.jpg");
        else rutaImagen = new ImageIcon("src/SPRITES/Muerte.png");

        imagen = new JLabel(rutaImagen);
        this.pj = pj;

    }

    public void abrir(){
        crearEscena();
        marco.setUndecorated(true);
        marco.setVisible(true);
    }


    private void crearEscena() {
        panelPrincipal.add(imagen, BorderLayout.NORTH);
        panelPrincipal.add(areaTexto, BorderLayout.CENTER);
        botonSalir.addActionListener(e -> System.exit(0));
        panelPrincipal.add(botonSalir, BorderLayout.SOUTH);


        marco.add(panelPrincipal);
        marco.setSize(900,600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
    }
}
