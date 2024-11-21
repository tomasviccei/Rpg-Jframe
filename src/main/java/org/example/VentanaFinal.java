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

    }

    public void abrir(){
        mansaje();
        crearEscena();
        marco.setVisible(true);
    }

    private void mansaje() {
        String mensajeFinal;
        if(condicion == VICTORIA){
            mensajeFinal = "Ganaste papu, la verdad no te tenia fe pero bien ahí.\n" + pj.getNombre() + " Nivel: "
                    +pj.getNivel() + " Has obtenido " + pj.getOro() + " monedas de oro";
        }else {
            mensajeFinal = "La quedaste como un terrible petón.\n"
                    + "La proxima trata de no ser tan malo si?.\n"
                    + "Dale probá de nuevo que no es tan dificil";
        }

        areaTexto.setText(mensajeFinal);
    }

    private void crearEscena() {
        panelPrincipal.add(imagen, BorderLayout.NORTH);
        panelPrincipal.add(areaTexto, BorderLayout.CENTER);
        botonSalir.addActionListener(e -> System.exit(0));
        panelPrincipal.add(botonSalir, BorderLayout.SOUTH);


        marco.add(panelPrincipal);
        marco.setSize(800,700);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
    }
}
