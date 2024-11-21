package org.example;

import javax.swing.*;
import java.awt.*;

public class Tienda {

    private JDialog marco;
    private JPanel panelPrincipal, panelSuperior, panelInferior, panelTienda;
    private JPanel panelAtaque, panelDefensa, panelPocion, panelMapa;

    private JLabel imagenAtaque, imagenDefensa, imagenPocion, imagenMapa;
    private JLabel desAtaque, desDefensa, desPocion, desMapa;
    private static JButton botAtaque, botDefensa, botPocion, botMapa;

    private boolean agoAtaque = false, agoDefensa = false, agoPocion = false, agoMapa = false;

    private JButton botSalir;
    private VentanaPrincipal vp;
    private Personaje pj;

    public Tienda(VentanaPrincipal vp) {

        this.vp = vp;
        pj = vp.getPj();

        marco = new JDialog();

        panelPrincipal = new JPanel(new BorderLayout());

        panelSuperior = vp.getPanelSup();
        panelInferior = new JPanel();
        panelTienda = new JPanel(new GridLayout(2,2));

        panelAtaque = new JPanel();
        panelDefensa = new JPanel();
        panelPocion = new JPanel();
        panelMapa = new JPanel();

        imagenAtaque = new JLabel(new ImageIcon("src/SPRITES/tienda/ataque.png"));
        imagenDefensa = new JLabel(new ImageIcon("src/SPRITES/tienda/defensa.png"));
        imagenPocion = new JLabel(new ImageIcon("src/SPRITES/tienda/pocion.png"));
        imagenMapa = new JLabel(new ImageIcon("src/SPRITES/tienda/map.png"));

        desAtaque = new JLabel("Ataque - 40 Oro.");
        desDefensa = new JLabel("Defensa - 60 Oro.");
        desPocion = new JLabel("Pocion - 50 Oro.");
        desMapa = new JLabel("Mapa - 10 Oro.");

        botAtaque = new JButton("Comprar");
        botDefensa = new JButton("Comprar");
        botPocion = new JButton("Comprar");
        botMapa = new JButton("Comprar");


        botSalir = new JButton("Salir");

    }

    public void abrirTienda(){

        crearInterfaz();
        marco.setVisible(true);
    }

    private void crearInterfaz() {
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        addObjeto(panelAtaque, imagenAtaque, desAtaque, botAtaque, "Ataque", agoAtaque);
        addObjeto(panelDefensa, imagenDefensa, desDefensa, botDefensa, "Defensa", agoDefensa);
        addObjeto(panelPocion, imagenPocion, desPocion, botPocion, "Pocion",agoPocion);
        addObjeto(panelMapa, imagenMapa, desMapa, botMapa, "Mapa", agoMapa);

        panelPrincipal.add(panelTienda, BorderLayout.CENTER);


        botSalir.addActionListener(e -> marco.dispose());
        panelInferior.add(botSalir);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        marco.setSize(800,700);
        marco.setLocationRelativeTo(null);
        marco.setModal(true);
        marco.add(panelPrincipal);

    }



    private void addObjeto(JPanel panObjeto, JLabel imagen, JLabel descripcion, JButton boton, String nombre, boolean agotado) {

        imagen.setAlignmentX(Component.CENTER_ALIGNMENT);
        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);

        if(agotado) boton.setEnabled(false);

        boton.addActionListener(e -> comprarObjeto(boton, nombre));

        panObjeto.setLayout(new BoxLayout(panObjeto, BoxLayout.Y_AXIS));
        panObjeto.add(imagen);
        panObjeto.add(descripcion);
        panObjeto.add(boton);

        panelTienda.add(panObjeto);
    }

    private void comprarObjeto(JButton boton, String nombre) {
        switch (nombre){
            case "Ataque":
                if(pj.getOro()>=40) {
                    pj.setAtaque(pj.getAtaque() + 3);
                    vp.getEtAtributos().setText(" Atck: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " Vida");
                    pj.setOro(pj.getOro() - 100);
                    vp.getEtOro().setText(" $: " + pj.getOro());
                    boton.setEnabled(false);
                    agoAtaque = true;
                }
                break;
            case "Defensa":
                if(pj.getOro()>=60) {
                    pj.setDefensa(pj.getDefensa() + 1);
                    vp.getEtAtributos().setText(" Atck: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " Vida");
                    pj.setOro(pj.getOro() - 80);
                    vp.getEtOro().setText(" $: " + pj.getOro());
                    boton.setEnabled(false);
                    agoDefensa = true;
                }
                break;
            case "Pocion":
                if(pj.getOro()>=50) {
                    pj.setVidaActual((int) pj.getVidaMax());
                    pj.establecerVida(pj.getVidaActual());
                    pj.setOro(pj.getOro() - 50);
                    vp.getEtOro().setText(" $: " + pj.getOro());
                    boton.setEnabled(false);
                    agoPocion = true;
                }
                break;
            case "Mapa":
                if(pj.getOro()>=10) {
                    Exploracion.setNumExploracion(250);
                    pj.setOro(pj.getOro() - 10);
                    vp.getEtOro().setText(" $: " + pj.getOro());
                    boton.setEnabled(false);
                    agoMapa = true;
                }
                break;
        }
    }

}
