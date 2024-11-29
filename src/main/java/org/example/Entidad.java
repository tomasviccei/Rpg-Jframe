package org.example;

import javax.swing.*;
import java.awt.*;

public class Entidad implements IAtacable {

    private String nombre;
    private int vidaActual, ataque, defensa; //, habilidadEspecial;
    private double vidaMax;
    private boolean estaVivo;
    private JProgressBar barraVida;

    public Entidad(String nombre, int ataque, int defensa, double vidaMax) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vidaMax = vidaMax;

        vidaActual = (int) vidaMax;
        estaVivo = true;
        barraVida = new JProgressBar(0, (int) vidaMax);
        barraVida.setPreferredSize(new Dimension(150, 25));
        establecerVida(vidaActual);

    }

        public void establecerVida(int vida){
            barraVida.setValue(vida);
            barraVida.setForeground(Color.GREEN);
            barraVida.setStringPainted(true);
            barraVida.setString(vidaActual + "/" + (int)vidaMax);

        }

    @Override
    public void atacar(IAtacable enemigo) {
        enemigo.recibirAtaque(ataque);
    }

    @Override
    public void recibirAtaque(int cantidad) {
        if (estaVivo) {
            int cantidadTotal = cantidad - defensa;
            if (cantidadTotal <= 0) cantidadTotal = 1;
            vidaActual -= cantidadTotal;
            if (vidaActual <= 0) {
                estaVivo = false;
                vidaActual = 0;
            }
        }
    }

//    public void habilidadEspecial(IAtacable enemigo){
//        enemigo.recibirHabilidad(ataque);
//    }
//    @Override
//    public void recibirHabilidad(int cantidad) {
//        if (estaVivo) {
//            int cantidadTotal = cantidad - defensa;
//            if (cantidadTotal <= 0) cantidadTotal = 1;
//            vidaActual -= cantidadTotal;
//            if (vidaActual <= 0) {
//                estaVivo = false;
//                vidaActual = 0;
//            }
//        }
//    }

    public JProgressBar getBarraVida() {
        return barraVida;
    }


    public void setBarraVida(JProgressBar barraVida) {
        this.barraVida = barraVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public double getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(double vidaMax) {
        this.vidaMax = vidaMax;
    }


}
