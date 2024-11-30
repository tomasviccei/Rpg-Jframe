package org.example;


import javax.swing.*;
import java.awt.*;

public class VentanaInicial extends JFrame {
    private Personaje personajeSeleccionado;

    public VentanaInicial() {
        setTitle("Selecciona tu Clase");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        ImageIcon imagenInicio = new ImageIcon("src/SPRITES/Inicio.png");
        JLabel etiquetaImagen = new JLabel(imagenInicio);
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiquetaImagen, BorderLayout.CENTER);


        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3, 10, 10));


        JButton botonCaballero = new JButton("Caballero");
        JButton botonMago = new JButton("Mago");
        JButton botonPaladin = new JButton("Paladín");


        botonCaballero.addActionListener(e -> seleccionarClase("Caballero"));
        botonMago.addActionListener(e -> seleccionarClase("Mago"));
        botonPaladin.addActionListener(e -> seleccionarClase("Paladín"));


        panelBotones.add(botonCaballero);
        panelBotones.add(botonMago);
        panelBotones.add(botonPaladin);


        add(panelBotones, BorderLayout.SOUTH); 
    }

    private void seleccionarClase(String clase) {
            this.personajeSeleccionado = LectorClases.crearPersonaje(clase, clase);
            dispose();
    }

    public Personaje getPersonajeSeleccionado() {
        return personajeSeleccionado;
    }
}