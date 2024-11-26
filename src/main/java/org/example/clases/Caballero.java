package org.example.clases;

import org.example.Entidad;
import org.example.Personaje;



public class Caballero extends Personaje {
    public Caballero(String nombre) {
        super(nombre, 10, 4, 100, "Golpe Poderoso");

    }


    @Override
    public void habilidadEspecial(Entidad enemigo) {
        if (isEstaVivo()) {
            int damage = getAtaque() + (2 * getNivel());
            enemigo.recibirAtaque(damage);

        }
    }

}