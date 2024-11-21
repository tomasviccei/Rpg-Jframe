package org.example;

public class Main {
    public static void main(String[] args) {
        Personaje heroe = new Personaje("El Papu", 10, 2, 80);

        VentanaPrincipal juego = new VentanaPrincipal(heroe);
        juego.ComenzarJuego();

    }
}

