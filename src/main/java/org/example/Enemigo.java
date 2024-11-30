package org.example;
import javax.swing.*;
import java.awt.*;


public class Enemigo extends Entidad{

    private int premioOro;
    private int premioExp;

    private JLabel etNombre, imagen;

    private static String[] enemigoFacil = {"Espiritu", "Goblin", "Anaconda"};
    private static String[] enemigoMedio = {"Mago oscuro", "Golem", "Druida", "Dragon"};




    public Enemigo(String nombre, int ataque, int defensa, double vidaMax, String dificultad) {
        super(nombre, ataque, defensa, vidaMax);

        etNombre = new JLabel(nombre);
        etNombre.setFont(new Font("Roboto", Font.BOLD, 20));
        String rutaImagen = "src/SPRITES/" + nombre.toLowerCase() + ".png";
        imagen = new JLabel();
        imagen.setIcon(new ImageIcon(rutaImagen));



        switch (dificultad) {
            case "facil":
                premioExp = (int) (Math.random()* 6 + 1);
                premioOro = (int) (Math.random()* 20 + 1);
                etNombre.setForeground(Color.GREEN);
                break;
            case "medio":
                premioExp = (int) (Math.random()* 15 + 1);
                premioOro = (int) (Math.random()* 50 + 1);
                etNombre.setForeground(Color.ORANGE);
                break;
            default:
                etNombre.setForeground(Color.RED);
                premioExp = 500;
                premioOro = 1000;
                break;
        }

    }


    public static Enemigo generarEnemigo (int i) {
        Enemigo e;
        int nEnemigo = (int) (Math.random()*3);
        int nVida = (int) (Math.random()*30);
        int nAtaque = (int) (Math.random()*6);
        int nDef = (int) (Math.random()*2);

        if(i<30){
            e = new Enemigo(enemigoFacil[nEnemigo],nAtaque + 1,nDef,nVida +15, "facil" );
        }else if(i<180){
            e = new Enemigo(enemigoMedio[nEnemigo],nAtaque + 4,nDef+2,nVida +30, "medio" );
        }else {
            e = new Enemigo("Bestia de tres cabezas",nAtaque +15,nDef+5,nVida +150, "Jefe" );
        }
        return e;
    }



    public int getPremioOro() {
        return premioOro;
    }

    public int getPremioExp() {
        return premioExp;
    }

    public JLabel getEtNombre() {
        return etNombre;
    }

    public JLabel getImagen() {
        return imagen;
    }




}
