package org.example;

public class Main {
    public static void main(String[] args) {
        VentanaInicial ventanaInicial = new VentanaInicial();
        ventanaInicial.setVisible(true);

        while (ventanaInicial.getPersonajeSeleccionado() == null) {
            try {
                Thread.sleep(100); // Pequeña pausa para evitar consumo innecesario de CPU.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Personaje heroe = ventanaInicial.getPersonajeSeleccionado();

        VentanaPrincipal juego = new VentanaPrincipal(heroe);
        juego.ComenzarJuego();

    }
}

