package org.example;

import org.example.panelPersonalizado.FramePer;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal  {

    private FramePer marco;
    private JPanel panelPrincipal, panelSuperior, panelInferior;
    private JLabel etNombre, etNivel, etExp, etOro, etAtributos;
    private JLabel etImagen;

    private JButton botonExplorar;

    private Personaje pj;

    public VentanaPrincipal(Personaje pj){

        this.pj = pj;

        marco = new FramePer(600, 500, "El Juego del papu", true);

        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = new JPanel();
        panelInferior = new JPanel();

        etNombre = new JLabel(pj.getNombre());
        etNivel = new JLabel(" Nivel: " + pj.getNivel());
        etExp = new JLabel(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
        etOro = new JLabel(" $: " + pj.getOro());
        etAtributos = new JLabel(" Atck: " + pj.getAtaque() + "/ Def:" + pj.getDefensa());
        etImagen = new JLabel();

        botonExplorar = new JButton("Explorar");
    }

    public void ComenzarJuego() {
        iniciarEscena();
        marco.setVisible(true);
    }

    public void iniciarEscena(){
        panelSuperior.add(etNombre);
        panelSuperior.add(etNivel);
        panelSuperior.add(etExp);
        panelSuperior.add(etOro);
        panelSuperior.add(etAtributos);
        panelSuperior.add(pj.getBarraVida());

        etImagen.setIcon(new ImageIcon("src/SPRITES/pngtree-enchanted-forest-at-night-square-format-3d-digital-illustration-of-a-image_3717224.jpg"));
        panelPrincipal.add(etImagen, BorderLayout.CENTER);
        botonExplorar.addActionListener(e -> nuevaExploracion());
        panelInferior.add(botonExplorar);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        marco.add(panelPrincipal);
    }

    private void nuevaExploracion() {
    }
}
