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
        botonCaballero.addActionListener(e -> seleccionarClase("Caballero"));
        botonMago.addActionListener(e -> seleccionarClase("Mago"));
        botonPaladin.addActionListener(e -> seleccionarClase("Paladín"));

        // Agregar botones al panel.
        panelBotones.add(botonCaballero);
        panelBotones.add(botonMago);
        panelBotones.add(botonPaladin);

        // Agregar el panel de botones a la ventana.
        add(panelBotones, BorderLayout.SOUTH); // Coloca los botones en la parte inferior.
    }

    private void seleccionarClase(String clase) {
        // Crear el personaje usando el método LectorClases
        try {
            this.personajeSeleccionado = LectorClases.crearPersonaje(clase, clase); // El nombre del personaje es el mismo que la clase.
            JOptionPane.showMessageDialog(this, "Has elegido: " + personajeSeleccionado.getNombre());
            dispose(); // Cierra la ventana.
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Personaje getPersonajeSeleccionado() {
        return personajeSeleccionado;
    }
}