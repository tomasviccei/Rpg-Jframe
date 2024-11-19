package org.example;

public class Personaje extends Entidad{

    private int nivel, oro, exp, expNecesaria;

    public Personaje(String nombre, int ataque, int defensa, double vidaMax) {
        super(nombre, ataque, defensa, vidaMax);
        nivel = 1;
        oro = 0;
        exp = 0;
        expNecesaria = 10;
    }

    public void subirExp(int cantidad) {
        exp+= cantidad;
        if(exp >= expNecesaria) subirNivel();
    }

    public void subirNivel(){
        nivel++;
        setAtaque(getAtaque() + 2);
        setDefensa(getDefensa() + 1);
        setVidaMax(getVidaMax() * 1.1);
        getBarraVida().setMaximum((int)getVidaMax());
        setVidaActual((int)getVidaMax());
        establecerVida((int)getVidaMax());
        expNecesaria += (expNecesaria + 5);
    }

    public int getNivel() {
        return nivel;
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
