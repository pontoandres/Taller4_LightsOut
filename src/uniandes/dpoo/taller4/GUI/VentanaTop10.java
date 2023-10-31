package uniandes.dpoo.taller4.GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Collection;

import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class VentanaTop10 extends JFrame {
    
    public VentanaTop10()
    {   
        setTitle("Top 10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new GridLayout(10,0));

        Top10 top10 = new Top10();
        Collection<RegistroTop10> registros = top10.darRegistros();
        int i = 1;
        for (RegistroTop10 registro : registros) {
            JLabel label = new JLabel(i + ") " +registro.toString());
            i++;
            add(label, Component.CENTER_ALIGNMENT);
        }
    }
}
