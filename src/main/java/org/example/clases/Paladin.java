package org.example.clases;

import org.example.Entidad;
import org.example.Personaje;

public class Paladin extends Personaje {
    private double porcentajeCuracion;
    public Paladin(String nombre) {
        super(nombre, 8, 6, 120, "Bendición divina");

        this.porcentajeCuracion = 1.02;

    }

    @Override
    public void habilidadEspecial(Entidad enemigo) {
        if (isEstaVivo()) {
            int curacion = (int) ((getVidaMax() * porcentajeCuracion) + (5 * getNivel()));
            int nuevaVida = getVidaActual() + curacion;
            if (nuevaVida > getVidaMax()) {
                nuevaVida = (int) getVidaMax();
            }
            setVidaActual(nuevaVida);
            establecerVida(nuevaVida);
        }
    }
}