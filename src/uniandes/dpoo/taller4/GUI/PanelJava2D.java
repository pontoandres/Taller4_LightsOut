package uniandes.dpoo.taller4.GUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;


public class PanelJava2D extends JPanel implements MouseListener{
    
    private boolean[][] tablero;
    
    public PanelJava2D( boolean[][] tableroP)
    {
        tablero= tableroP;
        add(new JLabel(  " Tablero"));
        addMouseListener( this );
    }
    
    
    public void paint(Graphics g)
    {


        Graphics2D g2d = (Graphics2D) g;
        int ancho= getWidth( );
        int alto= getHeight( );
        int anchoRect= ancho/tablero.length;
        int altoRect= alto/tablero.length;
        for( int i = 0; i < tablero.length; i++ )
        {
            for( int j = 0; j < tablero.length; j++ )
            {
                Rectangle2D.Double rect= new Rectangle2D.Double( i*anchoRect , j*altoRect, anchoRect, altoRect );
                if(tablero[i][j]==true)
                {
                    g.setColor( Color.YELLOW );
                }
                else
                {
                    g.setColor( Color.GRAY );
                }
                g2d.fill(rect);
                g.setColor( Color.BLACK );
                g2d.draw( rect );
            }
        }
    
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mousePressed( MouseEvent e )
    {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
//        cantidades[casilla[0]][casilla[1]]++;
//        principal.jugar(casilla[0], casilla[1]);
        if(tablero[casilla[0]][casilla[1]]==true)
        {
            tablero[casilla[0]][casilla[1]]=false;
        }
        else
        {
            tablero[casilla[0]][casilla[1]]=true;
        }
        repaint();
//        this.ultima_fila = casilla[0];
//        this.ultima_columna = casilla[1];
        
    }

    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    int ladoTablero = tablero.length;
    int altoPanelTablero = getHeight();
    int anchoPanelTablero = getWidth();
    int altoCasilla = altoPanelTablero / ladoTablero;
    int anchoCasilla = anchoPanelTablero / ladoTablero;
    int fila = (int) (y / altoCasilla);
    int columna = (int) (x / anchoCasilla);
    return new int[] { columna, fila };
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        
    }


    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
