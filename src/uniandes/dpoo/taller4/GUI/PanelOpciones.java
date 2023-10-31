package uniandes.dpoo.taller4.GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



public class PanelOpciones extends JPanel implements ActionListener{

    private JRadioButton facil;
    private JRadioButton medio;
    private JRadioButton dificil;
    private JComboBox opcionTamano;
    private ActionListener listener;

    public PanelOpciones()
    {
        setLayout(new FlowLayout());

        add(new JLabel("Tamaño:"));
        opcionTamano = new JComboBox();
        opcionTamano.addItem("5x5");
        opcionTamano.addItem("6x6");
        opcionTamano.addItem("9x9");
        add(opcionTamano);

        opcionTamano.addActionListener(listener);
        opcionTamano.setActionCommand("9x9");
        
        add(new JLabel("Dificultad:"));
        facil = new JRadioButton("Facil");
        medio = new JRadioButton("Medio");
        dificil = new JRadioButton("Dificil");
        add(facil);
        add(medio);
        add(dificil);
        Color azulClaro = new Color(173, 216, 230); // Define un azul claro
        setBackground(azulClaro);
    }

    @Override
    public void actionPerformed( ActionEvent evento )
    {
        if(evento.getActionCommand( ).equals( "9x9" ))
        {
            System.out.println("9x9");
        }
    }

}
