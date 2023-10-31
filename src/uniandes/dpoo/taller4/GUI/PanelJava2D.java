package uniandes.dpoo.taller4.GUI;

import javax.imageio.ImageIO;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;


public class PanelJava2D extends JPanel implements MouseListener{
    
    private boolean[][] tablero;
    private BufferedImage luzImage;
    
    public PanelJava2D( boolean[][] tableroP)
    {
        tablero= tableroP;
        add(new JLabel(  " Tablero"));
        addMouseListener( this );
        cargarImagen();
    }
    
    private void cargarImagen() {
        try {
            // Cargar la imagen desde el archivo
            luzImage = ImageIO.read(new File("./data/luz.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                BufferedImage image = luzImage;
                
                if(tablero[i][j]==true)
                {
                    g.drawImage(image, i*anchoRect, j*altoRect, anchoRect, altoRect, null);
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
        
        if(tablero[casilla[0]][casilla[1]]==true)
        {
            tablero[casilla[0]][casilla[1]]=false;
            if(casilla[0]-1>=0 && casilla[1]-1>=0 && casilla[0]-1<tablero.length && casilla[1]-1<tablero.length)
            {
                tablero[casilla[0]-1][casilla[1]-1]=false;
            }
            
            if(casilla[0]-1>=0 && casilla[1]>=0 && casilla[0]-1<tablero.length && casilla[1]<tablero.length)
            {
                tablero[casilla[0]-1][casilla[1]]=false;
            }
            
            if(casilla[0]>=0 && casilla[1]-1>=0 && casilla[0]<tablero.length && casilla[1]-1<tablero.length)
            {
                tablero[casilla[0]][casilla[1]-1]=false;
            }
            
            if(casilla[0]+1>=0 && casilla[1]-1>=0 && casilla[0]+1<tablero.length && casilla[1]-1<tablero.length)
            {
                tablero[casilla[0]+1][casilla[1]-1]=false;
            }
            
            if(casilla[0]-1>=0 && casilla[1]+1>=0 && casilla[0]-1<tablero.length && casilla[1]+1<tablero.length)
            {
                tablero[casilla[0]-1][casilla[1]+1]=false;
            }
            
            if(casilla[0]+1>=0 && casilla[1]>=0 && casilla[0]+1<tablero.length && casilla[1]<tablero.length)
            {
                tablero[casilla[0]+1][casilla[1]]=false;
            }
            
            if(casilla[0]>=0 && casilla[1]+1>=0 && casilla[0]<tablero.length && casilla[1]+1<tablero.length)
            {
                tablero[casilla[0]][casilla[1]+1]=false;
            }
            
            if(casilla[0]+1>=0 && casilla[1]+1>=0 && casilla[0]+1<tablero.length && casilla[1]+1<tablero.length)
            {
                tablero[casilla[0]+1][casilla[1]+1]=false;
            }
        }
        else
        {
            tablero[casilla[0]][casilla[1]]=true;
            if(casilla[0]-1>=0 && casilla[1]-1>=0 && casilla[0]-1<tablero.length && casilla[1]-1<tablero.length)
            {
                tablero[casilla[0]-1][casilla[1]-1]=true;
            }
            
            if(casilla[0]-1>=0 && casilla[1]>=0 && casilla[0]-1<tablero.length && casilla[1]<tablero.length)
            {
                tablero[casilla[0]-1][casilla[1]]=true;
            }
            
            if(casilla[0]>=0 && casilla[1]-1>=0 && casilla[0]<tablero.length && casilla[1]-1<tablero.length)
            {
                tablero[casilla[0]][casilla[1]-1]=true;
            }
            
            if(casilla[0]+1>=0 && casilla[1]-1>=0 && casilla[0]+1<tablero.length && casilla[1]-1<tablero.length)
            {
                tablero[casilla[0]+1][casilla[1]-1]=true;
            }
            
            if(casilla[0]-1>=0 && casilla[1]+1>=0 && casilla[0]-1<tablero.length && casilla[1]+1<tablero.length)
            {
                tablero[casilla[0]-1][casilla[1]+1]=true;
            }
            
            if(casilla[0]+1>=0 && casilla[1]>=0 && casilla[0]+1<tablero.length && casilla[1]<tablero.length)
            {
                tablero[casilla[0]+1][casilla[1]]=true;
            }
            
            if(casilla[0]>=0 && casilla[1]+1>=0 && casilla[0]<tablero.length && casilla[1]+1<tablero.length)
            {
                tablero[casilla[0]][casilla[1]+1]=true;
            }
            
            if(casilla[0]+1>=0 && casilla[1]+1>=0 && casilla[0]+1<tablero.length && casilla[1]+1<tablero.length)
            {
                tablero[casilla[0]+1][casilla[1]+1]=true;
            }
        }
        repaint();
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
