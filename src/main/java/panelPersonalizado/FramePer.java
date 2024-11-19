package panelPersonalizado;

import javax.swing.*;

public class FramePer extends JFrame {
    public FramePer(int ancho, int alto, String titulo, boolean esPrincipal){

        setSize(ancho, alto);
        setTitle(titulo);
        this.setLocationRelativeTo(null);

        if(esPrincipal) this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
