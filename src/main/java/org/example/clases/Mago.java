package org.example.clases;

import com.sun.source.tree.UsesTree;
import org.example.Entidad;
import org.example.Personaje;

public class Mago extends Personaje {
    private double multiplicadorMagico;

    public Mago(String nombre) {
        super(nombre, 15, 2, 80, "Bola de fuego");

        this.multiplicadorMagico = 1.1;
    }

    @Override
    public void habilidadEspecial(Entidad enemigo) {
        if (isEstaVivo()) {
            int damage = (int) (getAtaque() * multiplicadorMagico) + getNivel();
            enemigo.recibirAtaque(damage);

        }
    }




}
