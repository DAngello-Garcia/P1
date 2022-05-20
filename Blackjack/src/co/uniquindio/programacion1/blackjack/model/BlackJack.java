package co.uniquindio.programacion1.blackjack.model;
import java.util.ArrayList;
import java.util.Collections;

/**
*
* @author Jugutier
* @author SoniaJaramillo
* @author YordanArenas
* @author DAngelloGarcia
* @author SantiagoSepulveda
*/

public class BlackJack {
	/**
	 * Se declaran las variables de la clase	
	 */
	final int MAX_CARTAS_PINTA = 13;
	public ArrayList <Integer> cartasDealer;
	public ArrayList <Integer> baraja;
	public ArrayList <Integer> cartasOpo;
	/**
	 * Metodo para reservarle memoria al ArrayList
	 */
	public BlackJack() {
		cartasDealer = new ArrayList<>();
		baraja = new ArrayList<>();
		cartasOpo = new ArrayList<>();
	}
	
	/**
	 * Mezcla las cartas
	 * @param a ArrayList de baraja
	 */
	public void mezclarBaraja() {
		int max = 51, min = 0;
		for(int i = min; i <= max; i++) {
			baraja.add(i);
		}
		Collections.shuffle(baraja);
	}
	
	/**
	 * Permite repartir una carta al dealer
	 */
	public void repartirCartasDealer() {
		cartasDealer.add(baraja.get(0));
		baraja.remove(0);
	}
	/**
	 * Permite repartir una carta al oponente
	 */
	public void repartirCartasOpo() {
		cartasOpo.add(baraja.get(0));
		baraja.remove(0);
	}

	/**
	 * Devuelve el Arraylist con las cartas 
	 * que están en el tablero
	 * hasta el momento
	 * @return El ArrayList
	 */
	public ArrayList<Integer> getCartas(int reverso) {
		ArrayList<Integer> cartas = new ArrayList<>();
		cartas.add(reverso);
		for(int i = 0; i < cartasOpo.size(); i++) {
			cartas.add(cartasOpo.get(i));
		}
		for(int i = 0; i < cartasDealer.size(); i++) {
			cartas.add(cartasDealer.get(i));
		}
		return cartas;
	}

	/**
	 * Permite obtener el tipo de carta
	 * @param n El número de la carta 
	 * @return El tipo de la carta
	 */
	public  int obtenerTipoCarta(int n) {
		int tipoCarta;
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
	 *
	public  int devolverCartaPosicion(int i) {
		return cartas.get(i);
		
	}*/
	
	public ArrayList<Integer> asignarPuntajeOpo(ArrayList<Integer> cartasOpo) {
		
		ArrayList<Integer> puntaje = new ArrayList<>();
		int numero = 0;
		
		for (int i = 0; i<cartasOpo.size(); i++)
		{
			numero = obtenerTipoCarta(cartasOpo.get(i));
			if(numero> 0 && numero < 10)
			{
				puntaje.set(i, numero +1);
			}
			else
			{
				if(numero == 0)
				{
					puntaje.set(i, 1);
					verificarPuntaje();
				}
				else
				{
					puntaje.set(i, 10);
				}
			}
		}
		return puntaje;
	
	}
	
	public ArrayList<Integer> asignarPuntajeDealer(ArrayList<Integer> cartasDealer) {
		
		ArrayList<Integer> puntaje = new ArrayList<>();
		int numero = 0;
		int as=0;
		
		for (int i = 0; i<cartasDealer.size(); i++)
		{
			numero = obtenerTipoCarta(cartasDealer.get(i));
			if(numero> 0 && numero < 10)
			{
				puntaje.set(i, numero +1);
			}
			else
			{
				if(numero == 0)
				{
					as = verificarPuntaje(puntaje);
					puntaje.set(i, as);
					
				}
				else
				{
					puntaje.set(i, 10);
				}
			}
		}
		return puntaje;
	
	}
	
	public int obtenerPuntaje(ArrayList<Integer> puntaje)
	{
		int suma = 0; 
		
		for (int i = 0; i < puntaje.size(); i++)
		{
			suma += puntaje.get(i);
		}
		return suma;		
	}
	
	public int verificarPuntaje(ArrayList<Integer> puntaje)
	{
		int suma= obtenerPuntaje(puntaje);
		int as=1;
		
		if(suma < 10)
		{
			as = 11;
		}
		
		return as;
	}
	
	
	
}