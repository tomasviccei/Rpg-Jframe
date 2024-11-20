package org.example;

public class Main {
    public static void main(String[] args) {
        Personaje heroe = new Personaje("El Papu", 6, 2, 80);

        VentanaPrincipal vp = new VentanaPrincipal(heroe);
        vp.ComenzarJuego();

    }
}
