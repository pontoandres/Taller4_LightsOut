package uniandes.dpoo.taller4.GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
    
    private JButton nuevo;
    private JButton reiniciar;
    private JButton top10;
    private JButton cambiarJugador;

    public PanelBotones()
    {
        setLayout(new GridLayout(4,1));
        nuevo = new JButton("Nuevo");
        reiniciar = new JButton("Reiniciar");
        top10 = new JButton("Top 10");
        cambiarJugador = new JButton("Cambiar Jugador");

        Color azulClaro = new Color(173, 216, 230); // Define un azul claro
        nuevo.setBackground(azulClaro);
        reiniciar.setBackground(azulClaro);
        top10.setBackground(azulClaro);
        cambiarJugador.setBackground(azulClaro);
        
        add(nuevo);
        add(reiniciar);
        add(top10);
        add(cambiarJugador);
    }
}
