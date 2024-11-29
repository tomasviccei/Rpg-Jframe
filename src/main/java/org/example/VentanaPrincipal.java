package org.example;
import org.example.panelPersonalizado.FramePer;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal  {

    private FramePer marco;
    private JPanel panelPrincipal, panelSuperior, panelInferior;  //Agregar panel seleccion personajes
    private JLabel etNombre, etNivel, etExp, etOro, etAtributos;
    private JLabel etImagen;

    private JButton botonExplorar, botonTienda, botonSalir;

    private Personaje pj;

    public VentanaPrincipal(Personaje pj){

        this.pj = pj;

        marco = new FramePer(850, 600, "El Juego del papu", true);

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
        botonTienda = new JButton("Tienda");
        botonSalir = new JButton("Salir");

    }

    public void ComenzarJuego() {
        iniciarEscena();
        marco.setUndecorated(true);
        marco.setVisible(true);
    }

    public void iniciarEscena(){

        modFuentes();
        panelSuperior.add(etNombre);
        panelSuperior.add(etNivel);
        panelSuperior.add(etExp);
        panelSuperior.add(etOro);
        panelSuperior.add(etAtributos);
        panelSuperior.add(pj.getBarraVida());
        panelSuperior.add(pj.getBarraMana());

        etImagen.setIcon(new ImageIcon("src/SPRITES/castillo.jpg"));
        panelPrincipal.add(etImagen, BorderLayout.CENTER);
        botonExplorar.addActionListener(e -> nuevaExploracion());
        botonTienda.addActionListener(e -> abrirTienda());
        botonSalir.addActionListener(e -> marco.dispose());
        panelInferior.add(botonExplorar);
        panelInferior.add(botonTienda);
        panelInferior.add(botonSalir);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        marco.add(panelPrincipal);
    }

    private void abrirTienda() {
        Tienda t = new Tienda(this);
        t.abrirTienda();
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        marco.repaint();
    }

    private void modFuentes() {
        Font miFuente = new Font("Roboto", Font.BOLD, 20);
        etNombre.setFont(miFuente);
    }

    private void nuevaExploracion() {

        Exploracion ex = new Exploracion(this);
        ex.comenzarExploracion();
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        marco.repaint();

    }

    public Personaje getPj(){
        return pj;
    }

    public JPanel getPanelSup(){
        return panelSuperior;
    }

    public JLabel getEtExp() {
        return etExp;
    }

    public JLabel getEtAtributos() {
        return etAtributos;
    }

    public JLabel getEtNivel() {
        return etNivel;
    }

    public JLabel getEtOro() {
        return etOro;
    }
}
