
//Nombre: Ponto Andres Moreno
//Codigo Estudiante: 202224525

package uniandes.dpoo.taller4.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller4.modelo.Tablero;

//crea una clase que hereda de JFrame y se llama ventanaPrincipal
public class VentanaPrincipal extends JFrame{
    
    private PanelOpciones panelNorte;
    private PanelInfo panelSur;
    private PanelJava2D panelIzquierda;
    private PanelBotones panelDerecha;
    
    
    
    public VentanaPrincipal() {
        
        //le pone un titulo a la ventana
        setTitle("Ventana Principal");
        //le pone un tamaÃ±o a la ventana
        setSize(500, 500);
        //le dice a la ventana que se cierre cuando el usuario da click en el boton de cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //hace visible la ventana
        setLayout(new BorderLayout());

        Tablero tablero = new Tablero( 9 );
        
        panelNorte = new PanelOpciones( );
        add(panelNorte, BorderLayout.NORTH);

        panelSur = new PanelInfo( );
        add(panelSur, BorderLayout.SOUTH);
        
        //        JPanel contenedorCentro = new JPanel(new BorderLayout());
        //        contenedorCentro.add(panelIzquierda, BorderLayout.WEST);
        //        contendorCentro.add(panelDerecha, BorderLayout.EAST);
        //
        //        add(contenedorCentro, BorderLayout.CENTER);
        

        panelDerecha = new PanelBotones( );
        add(panelDerecha, BorderLayout.EAST);

        panelIzquierda = new PanelJava2D( tablero.darTablero( ) );
        add(panelIzquierda, BorderLayout.CENTER);
        
        // Esto se usa para que al cerrar la ventana se salven los resultados
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                salvarTop10();
            }
        });
    }


    public void salvarTop10()
    {
        //TODO: Implementar
    }
    
    //metodo main
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //crea una nueva ventana
        VentanaPrincipal ventana = new VentanaPrincipal();
        
        VentanaTop10 ventanaTop10 = new VentanaTop10();
        
        // Obtener el tamaño de la pantalla
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Calcular ubicaciones iniciales de las ventanas de manera relativa
        int ventana1X = screenWidth / 4;  // Un cuarto del ancho
        int ventana2X = screenWidth / 2;  // La mitad del ancho
        int ventanaY = screenHeight / 4;  // Un cuarto de la altura

        // Establecer las ubicaciones iniciales de las ventanas
        ventana.setLocation(ventana1X, ventanaY);
        ventanaTop10.setLocation(ventana2X, ventanaY);
        
        ventana.setVisible(true);
        ventanaTop10.setVisible(true);

        FlatLightLaf.install();
    }
}