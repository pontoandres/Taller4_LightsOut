package uniandes.dpoo.taller4.GUI;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel {

    public PanelInfo() {
        
        setLayout(new FlowLayout());
        add(new JLabel("Jugadas:"));

        add(new JLabel("Jugador:"));
    }
    
}
