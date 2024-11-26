package org.example;

public class Main {
    public static void main(String[] args) {
        // Mostrar ventana inicial.
        VentanaInicial ventanaInicial = new VentanaInicial();
        ventanaInicial.setVisible(true);

        // Esperar hasta que el usuario seleccione una clase.
        while (ventanaInicial.getClaseSeleccionada() == null || ventanaInicial.getNombrePersonaje() == null) {
            try {
                Thread.sleep(100); // Pausa para evitar consumo innecesario de CPU.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Crear el personaje usando el lector de JSON.
        String claseSeleccionada = ventanaInicial.getClaseSeleccionada();
        String nombrePersonaje = ventanaInicial.getNombrePersonaje();
        Personaje heroe = LectorClases.crearPersonaje(claseSeleccionada, nombrePersonaje);

        // Iniciar el juego con el personaje creado.
        VentanaPrincipal juego = new VentanaPrincipal(heroe);
        juego.ComenzarJuego();
    }
}