package org.example;

import org.example.panelPersonalizado.FramePer;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal  {

    private FramePer marco;
    private JPanel panelPrincipal, panelSuperior, panelInferior;  //Agregar panel seleccion personajes
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
        // Crear panel de seleccion de personaje

        etNombre = new JLabel(pj.getNombre() + "  ");
        etNivel = new JLabel(" Nivel: " + pj.getNivel());
        etExp = new JLabel(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
        etOro = new JLabel(" $: " + pj.getOro());
        etAtributos = new JLabel(" Atck: " + pj.getAtaque() + " | Def: " + pj.getDefensa() + " Vida");
        etImagen = new JLabel();

        botonExplorar = new JButton("Explorar");
        // Crear boton de seleccion de personaje y tambien crear logica para seleccionar pj

    }

    public void ComenzarJuego() {
        iniciarEscena();
        marco.setVisible(true);
    }

    public void iniciarEscena(){

        modFuentes();
         //elegirPersonaje()  ---> crear metodo y clase
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

    private void modFuentes() {
        Font miFuente = new Font("Roboto", Font.BOLD, 20);
        etNombre.setFont(miFuente);
    }

    private void nuevaExploracion() {
        Exploracion ex = new Exploracion(this);
        ex.comenzarExploracion();
    }

    public Personaje getPj(){
        return pj;
    }

    public JPanel getPanelSup(){
        return panelSuperior;
    }
}
