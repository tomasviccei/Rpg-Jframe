package org.example;

import javax.swing.*;
import java.awt.*;

public class Personaje extends Entidad {

    private int nivel, oro, exp, expNecesaria, manaActual;
    private String habilidadEspecial;
    private double manaMax;
    private int costoManaHabilidad;
    private JProgressBar barraMana;


    public Personaje(String nombre, int ataque, int defensa, double vidaMax, double manaMax, String habilidadEspecial, int costoManaHabilidad) {
        super(nombre, ataque, defensa, vidaMax);
        nivel = 1;
        oro = 0;
        exp = 0;
        expNecesaria = 10;
        manaActual = (int) manaMax;
        this.habilidadEspecial = habilidadEspecial;
        this.manaMax = manaMax;
        this.costoManaHabilidad = costoManaHabilidad;
        barraMana = new JProgressBar(0, (int) manaMax);
        barraMana.setPreferredSize(new Dimension(100, 25));
        establecerMana(manaActual);
    }

    public void establecerMana(int mana){
        barraMana.setValue(mana);
        barraMana.setForeground(Color.BLUE);
        barraMana.setStringPainted(true);
        barraMana.setString(manaActual + "/" + (int)manaMax);
    }


    // Métodos para subir de nivel y ganar experiencia
    public void subirExp(int cantidad) {
        exp += cantidad;
        while (exp >= expNecesaria) subirNivel();
    }

    public void subirNivel() {
        nivel++;
        setAtaque(getAtaque() + 2);
        setDefensa(getDefensa() + 1);
        setVidaMax(getVidaMax() * 1.1);
        getBarraVida().setMaximum((int) getVidaMax());
        setVidaActual((int) getVidaMax());
        establecerVida((int) getVidaMax());
        expNecesaria += (expNecesaria + 5);
    }

    public void habilidadEspecial() {
    }

    public void setManaActual(int manaActual) {
        this.manaActual = manaActual;
    }

    public int getManaActual() {
        return manaActual;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public double getManaMax() {
        return manaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public int getCostoManaHabilidad() {
        return costoManaHabilidad;
    }

    public void setCostoManaHabilidad(int costoManaHabilidad) {
        this.costoManaHabilidad = costoManaHabilidad;
    }

    public int getNivel() {
        return nivel;
    }

    public JProgressBar getBarraMana() {
        return barraMana;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpNecesaria() {
        return expNecesaria;
    }

    public void setExpNecesaria(int expNecesaria) {
        this.expNecesaria = expNecesaria;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }
}