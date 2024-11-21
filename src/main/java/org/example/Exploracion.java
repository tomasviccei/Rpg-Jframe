package org.example;

import javax.swing.*;
import java.awt.*;

public class Exploracion {

    private JDialog marco;

    private JPanel panelPrincipal, panelSuperior, panelInferior, panelEnemigo, panelEnemigoSec;

    private JButton botAtacar, botHuir;

    private JTextArea infoTexto;
    private JScrollPane barraDes;

    private Personaje pj;
    private Enemigo enemigo;

    private static int numExploracion = 0;

    public Exploracion(VentanaPrincipal vp) {

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
        botHuir = new JButton("Huir");
    }

    public void comenzarExploracion() {

        decidirDificultad();
        iniciarInterfaz();
    }
    
    private void decidirDificultad(){
        
        int numRandom = (int) (Math.random()*100) + numExploracion;
        numExploracion ++;
        enemigo = Enemigo.generarEnemigo(numRandom);
    }
    
    private void iniciarInterfaz(){
        
        panelPrincipal.add(barraDes, BorderLayout.CENTER);

        panelEnemigoSec.add(enemigo.getEtNombre());
        panelEnemigoSec.add(enemigo.getBarraVida());

        panelEnemigo.setLayout(new BoxLayout(panelEnemigo, BoxLayout.Y_AXIS));
        panelEnemigo.add(enemigo.getImagen());
        panelEnemigo.add(panelEnemigoSec);
        
        botAtacar.addActionListener(e -> atacar());
        botHuir.addActionListener(e -> marco.dispose());

        panelInferior.add(botAtacar);
        panelInferior.add(new JLabel("           "));
        panelInferior.add(botHuir);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior,BorderLayout.SOUTH);
        panelPrincipal.add(panelEnemigo, BorderLayout.EAST);

        marco.add(panelPrincipal);
        marco.setSize(800,600);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.setVisible(true);
        
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
        }else {
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

    }
    private void derrota() {
        //Usar este metodo para verificar y mostrar la pantalla de muerte

    }

}
