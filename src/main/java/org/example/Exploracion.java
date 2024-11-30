package org.example;

import javax.swing.*;
import java.awt.*;

public class Exploracion {

    private JDialog marco;

    private JPanel panelPrincipal, panelSuperior, panelInferior, panelEnemigo, panelEnemigoSec;

    private JButton botAtacar, botHuir, botHabilidadEspecial;

    private JTextArea infoTexto;
    private JScrollPane barraDes;

    private Personaje pj;
    private Enemigo enemigo;

    private static int numExploracion = 0;

    private VentanaPrincipal vp;

    private boolean esJefe = false;

    public Exploracion(VentanaPrincipal vp) {

        this.vp = vp;
        pj = vp.getPj();
        marco = new JDialog();

        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = vp.getPanelSup();
        panelInferior = new JPanel();
        panelEnemigo = new JPanel();
        panelEnemigoSec = new JPanel();

        infoTexto = new JTextArea();
        infoTexto.setEditable(false);
        barraDes = new JScrollPane(infoTexto);
        barraDes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        botAtacar = new JButton("Atacar");
        botHabilidadEspecial = new JButton("Habilidad Especial");
        botHuir = new JButton("Huir");
    }


    
    private void decidirDificultad(){
        
        int numRandom = (int) (Math.random()*100) + numExploracion;
        numExploracion ++;
        enemigo = Enemigo.generarEnemigo(numRandom);

        if(enemigo.getNombre().equals("Bestia de tres cabezas")) esJefe = true;
    }
    
    private void iniciarInterfaz(){
        
        panelPrincipal.add(barraDes, BorderLayout.CENTER);

        panelEnemigoSec.add(enemigo.getEtNombre());
        panelEnemigoSec.add(enemigo.getBarraVida());

        panelEnemigo.setLayout(new BoxLayout(panelEnemigo, BoxLayout.Y_AXIS));
        panelEnemigo.add(enemigo.getImagen());
        panelEnemigo.add(panelEnemigoSec);
        
        botAtacar.addActionListener(e -> atacar());
        botHabilidadEspecial.addActionListener(e -> usarHabilidadEspecial());
        botHuir.addActionListener(e -> {
            numExploracion++;
            marco.dispose();
        });

        panelInferior.add(botAtacar);
        panelInferior.add(new JLabel("           "));
        panelInferior.add(botHabilidadEspecial);
        panelInferior.add(new JLabel("           "));
        if(esJefe) {
            botHuir.setEnabled(false);
        }
        panelInferior.add(botHuir);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior,BorderLayout.SOUTH);
        panelPrincipal.add(panelEnemigo, BorderLayout.EAST);

        marco.add(panelPrincipal);
        marco.setUndecorated(true);
        marco.setSize(900,600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.setVisible(true);
        
    }

    public void comenzarExploracion() {

        decidirDificultad();
        iniciarInterfaz();
    }


    private void atacar() {

        int damage;

        pj.atacar(enemigo);
        infoTexto.setText(infoTexto.getText() + pj.getNombre() +
                " Realiza un ataque causando " + pj.getAtaque() +" de daño" + ".\n" + ".\n");
        damage = pj.getAtaque() - enemigo.getDefensa();
        if(damage <= 0)  damage = 1;
        infoTexto.setText(infoTexto.getText() + enemigo.getNombre() + " ha recibido " + damage + " puntos de daño" + ".\n" + ".\n");

        enemigo.establecerVida(enemigo.getVidaActual());



        if(!enemigo.isEstaVivo()) {
            enemigoDerrotado();
        }

        else {
            enemigo.atacar(pj);
            infoTexto.setText(infoTexto.getText() + enemigo.getNombre() +
                    " Realiza un ataque que causa " + enemigo.getAtaque() + " puntos de daño"+ ".\n" + ".\n");
            damage = enemigo.getAtaque() - pj.getDefensa();
            if(damage <= 0)  damage = 1;
            infoTexto.setText(infoTexto.getText() + pj.getNombre() + " ha recibido un ataque que le causa " + damage + " puntos de daño " + ".\n" + ".\n");
            pj.establecerVida(pj.getVidaActual());

            if(!pj.isEstaVivo()) derrota();
        }

    }

    private void usarHabilidadEspecial(){

        int damage;

        if (pj.getManaActual()>= pj.getCostoManaHabilidad()) {
            pj.setManaActual(pj.getManaActual() - pj.getCostoManaHabilidad());
            pj.establecerMana(pj.getManaActual());
            switch (pj.getHabilidadEspecial()) {

                case "Espada Divina":
                    infoTexto.setText(infoTexto.getText() + pj.getNombre() + " usa " + pj.getHabilidadEspecial());
                    damage = 22 - enemigo.getDefensa();
                    if(damage <= 0)  damage = 1;
                    infoTexto.setText(infoTexto.getText() + enemigo.getNombre() + " ha recibido " + damage + " puntos de daño" + ".\n" + ".\n");
                    enemigo.recibirAtaque(damage);
                    enemigo.establecerVida(enemigo.getVidaActual());
                    pj.establecerMana(pj.getManaActual());
                    break;

                case "Bola de Fuego":
                    infoTexto.setText(infoTexto.getText() + pj.getNombre() + " usa " + pj.getHabilidadEspecial());
                    damage = 30 - enemigo.getDefensa();
                    if(damage <= 0)  damage = 1;
                    infoTexto.setText(infoTexto.getText() + enemigo.getNombre() + " ha recibido " + damage + " puntos de daño" + ".\n" + ".\n");
                    enemigo.recibirAtaque(damage);
                    enemigo.establecerVida(enemigo.getVidaActual());
                    pj.establecerMana(pj.getManaActual());
                    break;

                case "Bendicion Divina":
                    infoTexto.setText(infoTexto.getText() + pj.getNombre() + " usa " + pj.getHabilidadEspecial());
                    double nuevaVida = pj.getVidaActual() + 20;
                    if (nuevaVida > pj.getVidaMax()) {
                        nuevaVida = pj.getVidaMax();
                    }
                    pj.setVidaActual((int) nuevaVida);
                    infoTexto.setText(infoTexto.getText() + " activa " + pj.getHabilidadEspecial() + " y se cura 20 de vida!");
                    pj.establecerMana(pj.getManaActual());
                    break;

            }
        } else {
            infoTexto.setText(infoTexto.getText() + "No tienes el mana suficiente. \n " );
            botHabilidadEspecial.setEnabled(false);
        }

        if(!enemigo.isEstaVivo()) {
            enemigoDerrotado();
        }

        else {
            enemigo.atacar(pj);
            infoTexto.setText(infoTexto.getText() + enemigo.getNombre() +
                    " Realiza un ataque que causa " + enemigo.getAtaque() + " puntos de daño"+ ".\n" + ".\n");
            damage = enemigo.getAtaque() - pj.getDefensa();
            if(damage <= 0)  damage = 1;
            infoTexto.setText(infoTexto.getText() + pj.getNombre() + " ha recibido un ataque que le causa " + damage + " puntos de daño " + ".\n" + ".\n");
            pj.establecerVida(pj.getVidaActual());

            if(!pj.isEstaVivo()) derrota();
        }
    }


    private void enemigoDerrotado() {
        botAtacar.setEnabled(false);
        botHabilidadEspecial.setEnabled(false);
        botHuir.setText("Salir");

        infoTexto.setText(infoTexto.getText() + enemigo.getNombre() + " ha sido derrotado.\n"
                + "Has obtenido " + enemigo.getPremioOro() + " oro.\n"
                + "Ganas " + enemigo.getPremioExp() + " puntos de experiencia");

        pj.subirExp(enemigo.getPremioExp());
        vp.getEtExp().setText(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
        vp.getEtNivel().setText(" Nivel: " + pj.getNivel());
        vp.getEtAtributos().setText(" Atck: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " Vida: ");

        pj.setOro(pj.getOro() + enemigo.getPremioOro());
        vp.getEtOro().setText(" $: " + pj.getOro());

        if(esJefe) {
            VentanaFinal v = new VentanaFinal(VentanaFinal.VICTORIA, pj);
            v.abrir();
        }

    }

    private void derrota() {

        VentanaFinal v = new VentanaFinal(VentanaFinal.DERROTA, pj);
        v.abrir();
    }

    public static void setNumExploracion(int numExploracion) {
        Exploracion.numExploracion = numExploracion;
    }
}
