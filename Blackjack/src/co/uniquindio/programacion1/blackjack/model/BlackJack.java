package co.uniquindio.programacion1.blackjack.model;
import java.util.ArrayList;
import java.util.Collections;

/**
*
* @author Jugutier
* @author SoniaJaramillo
* @author YordanArenas
* @author DAngelloGarcia
*/

public class BlackJack {
/**
 * Se declaran las variables de la clase	
 */
final  int MAX_CARTAS_PINTA = 13;
private ArrayList <Integer> cartas;
private ArrayList <Integer> baraja;

/**
 * Metodo para reservarle memoria al ArrayList
 */
public BlackJack() {
	cartas = new ArrayList<>();
	baraja = new ArrayList<>();
}

/**
 * Mezcla las cartas
 * @param a ArrayList de baraja
 */
public void mezclarBaraja() {
	int max = 52, min = 1;
	for(int i = min; i <= max; i++) {
		baraja.add(i);
	}
	Collections.shuffle(baraja);
}

/**
 * Permite repartir una carta
 */
public void repartirCartas() {
	cartas.add(baraja.get(0));
	baraja.remove(0);
}

/**
 * Devuelve el Arraylist con las cartas 
 * que están en el tablero
 * hasta el momento
 * @return El ArrayList
 */
public ArrayList<Integer> getCartas() {
	return cartas;
}

/**
 * Permite obtener el tipo de carta
 * @param n El número de la carta 
 * @return El tipo de la carta
 */
public  int obtenerTipoCarta(int n) {
	int tipoCarta;
	inicializarReverso(n);
	tipoCarta = n % MAX_CARTAS_PINTA;
	return tipoCarta;
}

/**
 * Permite obtener el tipo Pinta
 * @param n El número de la carta
 * @return El tipoPinta
 */
public int obtenerTipoPinta(int n) {
	int tipoPinta;
	int tipoCarta=obtenerTipoCarta(n);
	tipoPinta = (n - tipoCarta) / MAX_CARTAS_PINTA;
	return tipoPinta;
}

/**
 * Permite inicializar el reverso
 * @param n El número de la carta
 */ 
public  void inicializarReverso (int n){
	if (n < 0 || n > REVERSO) {
	     n = REVERSO;
	  }

}

/**
 * Devuelve la maximo de cartas pinta
 * @return  MAX_CARTAS_PINTA
 */
public  int getMaxCartasPinta() {
	return MAX_CARTAS_PINTA;
}

/**
 * Devuelve el reverso
 * @return El reverso
 */
public int getReverso() {
	int n = baraja.get(0);
	baraja.remove(0);
	return n;
}

/**
 * Devuelve el número de la carta que está en la posición
 * i
 * @param i La posicion dentro del ArrayList
 * @return El número correspondiente a la carta que está
 * en la posicion
 */
public  int devolverCartaPosicion(int i) {
	return cartas.get(i);
	
}

	    
}
