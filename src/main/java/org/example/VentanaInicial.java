package org.example;

import org.example.clases.Caballero;
import org.example.clases.Mago;
import org.example.clases.Paladin;

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

        // Cargar la imagen.
        ImageIcon imagenInicio = new ImageIcon("src/SPRITES/Inicio.png"); // Asegúrate de que "Inicio.png" esté en la misma carpeta o usa la ruta completa.
        JLabel etiquetaImagen = new JLabel(imagenInicio);
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        add(etiquetaImagen, BorderLayout.CENTER);

        // Panel para los botones.
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3, 10, 10)); // 3 botones en fila, con espaciado.

        // Botones de selección.
        JButton botonCaballero = new JButton("Caballero");
        JButton botonMago = new JButton("Mago");
        JButton botonPaladin = new JButton("Paladín");

        // Agregar acciones a los botones.
        botonCaballero.addActionListener(e -> seleccionarClase(new Caballero("Caballero")));
        botonMago.addActionListener(e -> seleccionarClase(new Mago("Mago")));
        botonPaladin.addActionListener(e -> seleccionarClase(new Paladin("Paladín")));

        // Agregar botones al panel.
        panelBotones.add(botonCaballero);
        panelBotones.add(botonMago);
        panelBotones.add(botonPaladin);

        // Agregar el panel de botones a la ventana.
        add(panelBotones, BorderLayout.SOUTH); // Coloca los botones en la parte inferior.
    }

    private void seleccionarClase(Personaje pj) {
        this.personajeSeleccionado = pj;
        //JOptionPane.showMessageDialog(this, "Has elegido: " + pj.getNombre());
        dispose(); // Cierra la ventana.
    }

    public Personaje getPersonajeSeleccionado() {
        return personajeSeleccionado;
    }
}