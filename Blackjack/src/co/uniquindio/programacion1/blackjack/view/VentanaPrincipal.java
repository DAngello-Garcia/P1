package co.uniquindio.programacion1.blackjack.view;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.uniquindio.programacion1.blackjack.model.BlackJack;

/**
 *
 * @author Jugutier
 * @author SoniaJaramillo 
 * @author YordanArenas
 * @author DAngelloGarcia
 * @author SantiagoSepulveda
 */
public class VentanaPrincipal {

/**
 * Constantes para el tamaño de las cartas	
 */
	final static int MAX_ANCHO_CARTA = 125;
	final static int MAX_LARGO_CARTA = 158;
 
 /**
  * Método main   
  * @param args Los argumentos de la línea de comandos
  * @throws IOException
  */
    public static void main(String[] args) throws IOException
    {
        ImageIcon a[];
        int respuesta, reverso;        
        BlackJack miBlackJack = new BlackJack();
        boolean continuar = true;

        //ImageIcon miImage = obtenerImagenCarta(25, miBlackJack);
        //mostrarImagenCarta(miImage, 11);
       
        miBlackJack.mezclarBaraja();
        reverso = miBlackJack.getReverso();
        System.out.println("reverso : "+ reverso);
        miBlackJack.repartirCartasOpo();
        System.out.println("usuario: "+ miBlackJack.cartasOpo.get(0));
        miBlackJack.repartirCartasDealer();
        System.out.println("dealer: "+ miBlackJack.cartasDealer.get(0));
        miBlackJack.repartirCartasOpo();
        System.out.println("usuario: "+ "/n"+miBlackJack.cartasOpo.get(1));
        
        a = new ImageIcon[miBlackJack.getCartas(52).size()]; //tamaño de las cartas en la mesa
        a = inicializarImageIcon(miBlackJack.getCartas(52), miBlackJack);
        
        //ImageIcon miImage = obtenerImagenCarta(miBlackJack.getReverso(), miBlackJack);
        mostrarImagenCarta(a);
        
        
        for(int i=0; continuar == true; i++)
        {	
        	respuesta = preguntarImagenCarta(a);
        	if (respuesta == JOptionPane.YES_OPTION) {
            	JOptionPane.showMessageDialog(null, "Excelente, una nueva carta");
            	 miBlackJack.repartirCartasOpo();
            	 System.out.println("usuario: "+ miBlackJack.cartasOpo.get(0));
            	 miBlackJack.repartirCartasDealer();
            	 System.out.println("dealer: "+ miBlackJack.cartasDealer.get(0));
            	
        } 	else {
            	JOptionPane.showMessageDialog(null, "Muchas gracias");
            	continuar = false;
        	}
        }
    }

 /**
  *    
  * @param aux
  * @param miBlackJack
  * @return
  * @throws IOException
  */
    public static ImageIcon[] inicializarImageIcon(ArrayList <Integer> aux, BlackJack miBlackJack) throws IOException {
    ImageIcon a[] = new ImageIcon[aux.size()];	
    for(int i=0; i<aux.size(); i++) {
     	a[i]= obtenerImagenCarta(aux.get(i), miBlackJack);    	
    }
    return a;
    }
    
    /**
     * Método para obtener una imagen de la baraja de poker incluyendo el
     * reverso
     *
     * @param n NÃºmero de la carta ( 0 .. 51 ) y 52 es el reverso
     * @return Imagen de la carta indicada o el reverso
     * @throws IOException
     */
    public static ImageIcon obtenerImagenCarta(int n, BlackJack miB) throws IOException {
    	int tipoCarta, tipoPinta;
        BufferedImage baraja;
        ImageIcon carta;

        tipoCarta = miB.obtenerTipoCarta(n);
        tipoPinta = miB.obtenerTipoPinta(n);
        baraja = ImageIO.read(VentanaPrincipal.class.getResource("baraja-poker.jpg"));
        carta = new ImageIcon(baraja.getSubimage(tipoCarta * MAX_ANCHO_CARTA, tipoPinta * MAX_LARGO_CARTA, MAX_ANCHO_CARTA, MAX_LARGO_CARTA));

        return carta;
    }

    /**
     * Método que muestra la imagen o imagenes ( ignora los null del arreglo) en
     * un JOptionPane indicando el valor
     *
     * @param carta ImageIcon o arreglo de ImageIcon que son mostrados en un
     * JOptionPane
     * @param valor Valor de la carta o cartas
     */
    public static void mostrarImagenCarta(Object carta) {
        JOptionPane.showMessageDialog(null, carta, "Cartas ", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Método que muestra la imagen o imagenes ( ignora los null del arreglo) en
     * un JOptionPane indicando el valor
     *
     * @param carta ImageIcon o arreglo de ImageIcon que son mostrados en un
     * JOptionPane
     * @param valor Valor de la carta o cartas
     */
    
    public static int preguntarImagenCarta(Object carta) {
        return JOptionPane.showConfirmDialog(null, carta, "Pregunta ", JOptionPane.YES_NO_OPTION, 0, new ImageIcon(VentanaPrincipal.class.getResource("Pregunta.png")));
    }

 
}