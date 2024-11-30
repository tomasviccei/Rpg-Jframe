package org.example;


import javax.swing.*;
import java.awt.*;

public class VentanaInicial extends JFrame {
    private Personaje personajeSeleccionado;

    public VentanaInicial() {
        setTitle("Selecciona tu Clase");
        setSize(900, 700); // Ajusta el tamaño para la imagen y botones.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Usa BorderLayout para separar imagen y botones.


        ImageIcon imagenInicio = new ImageIcon("src/SPRITES/Inicio.png"); // Asegúrate de que "Inicio.png" esté en la misma carpeta o usa la ruta completa.
        JLabel etiquetaImagen = new JLabel(imagenInicio);
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiquetaImagen, BorderLayout.CENTER);


        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3, 10, 10)); // 3 botones en fila, con espaciado.


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