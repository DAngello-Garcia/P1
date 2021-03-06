package co.uniquindio.programacion1.blackjack.model;
import java.util.ArrayList;
import java.util.Arrays;
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
	 * devuelve las cartas del dealer
	 * @return
	 */
	public ArrayList<Integer> getCartasDealer() {
		return cartasDealer;
	}

	/**
	 * devuelve las cartas del oponente
	 * @return
	 */
	public ArrayList<Integer> getCartasOpo() {
		return cartasOpo;
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
	 * Devuelve el Arraylist con las cartas que est?n en el tablero hasta el momento
	 * @param reverso
	 * @return El ArrayList
	 */
	public ArrayList<Integer> getCartas(int reverso) {
		ArrayList<Integer> cartas = new ArrayList<>();
		if ( reverso == 52) {
			cartas.add(reverso);
			for(int i = 0; i < cartasOpo.size(); i++) {
				cartas.add(cartasOpo.get(i));
			}
			for(int i = 1; i < cartasDealer.size(); i++) {
				cartas.add(cartasDealer.get(i));
			}
			
		} else {
			for(int i = 0; i < cartasOpo.size(); i++) {
				cartas.add(cartasOpo.get(i));
			}
			for(int i = 0; i < cartasDealer.size(); i++) {
				cartas.add(cartasDealer.get(i));
			}
		}
		return cartas;
		
	}

	/**
	 * Permite obtener el valor del elemento de la columna en la imagen
	 * @param n El n?mero de la carta 
	 * @return El tipo de la carta
	 */
	public  int obtenerTipoCarta(int n) {
		int tipoCarta;
		tipoCarta = n % MAX_CARTAS_PINTA;
		return tipoCarta;
	}
	
	/**
	 * Permite obtener el valor del elemento de la fila en la imagen
	 * @param n El n?mero de la carta
	 * @return El tipoPinta
	 */
	public int obtenerTipoPinta(int n) {
		int tipoPinta;
		int tipoCarta=obtenerTipoCarta(n);
		tipoPinta = (n - tipoCarta) / MAX_CARTAS_PINTA;
		return tipoPinta;
	}
	
	/**
	 * Devuelve el reverso
	 * @return El reverso
	 */
	public int getReverso() {
		int n = baraja.get(0);
		baraja.remove(0);
		cartasDealer.add(n);
		return n;
	}
	
	/**
	 * asigna valores num?ricos a las cartas
	 * @param cartasOpo
	 * @return arraylist con el valor num?rico de las cartas
	 */
	public int asignarPuntajeOpo(ArrayList<Integer> cartasOpo) {
		
		ArrayList<Integer> puntaje = new ArrayList<>();
		int numero = 0;
		int as = 0;
		int punt = 0;
		
		for (int i = 0; i<cartasOpo.size(); i++)
		{
			numero = obtenerTipoCarta(cartasOpo.get(i));
			if(numero> 0 && numero < 10)
			{
				puntaje.add(numero + 1);
			}
			else
			{
				if(numero == 0)
				{
					as = verificarPuntaje(puntaje);
					puntaje.add(as);
					
				}
				else
				{
					puntaje.add(10);
				}
			}
		}
		punt = obtenerPuntaje(puntaje);
		return punt;
	
	}
	
	/**
	 * asigna valores num?ricos a las cartas
	 * @param cartasDealer
	 * @return arraylist con el valor num?rico de las cartas
	 */
	public int asignarPuntajeDealer(ArrayList<Integer> cartasDealer) {
		
		ArrayList<Integer> puntaje = new ArrayList<>();
		int numero = 0;
		int as=0;
		int punt = 0;
		for (int i = 0; i<cartasDealer.size(); i++)
		{
			numero = obtenerTipoCarta(cartasDealer.get(i));
			if(numero> 0 && numero < 10)
			{
				puntaje.add(numero + 1);
			}
			else
			{
				if(numero == 0)
				{
					as = verificarPuntaje(puntaje);
					puntaje.add(as);
					
				}
				else
				{
					puntaje.add(10);
				}
			}
		}
		punt = obtenerPuntaje(puntaje);
		return punt;
	
	}
	
	/**
	 * obtiene el puntaje total de las cartas
	 * @param puntaje
	 * @return puntaje total
	 */
	public int obtenerPuntaje(ArrayList<Integer> puntaje)
	{
		int suma = 0; 
		
		for (int i = 0; i < puntaje.size(); i++)
		{
			suma += puntaje.get(i);
		}
		return suma;		
	}
	
	/**
	 * le da un valor al as
	 * @param puntaje
	 * @return el valor del as
	 */
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
	
	/**
	 * verifica que el puntaje del dealer sea menor a 17 puntos
	 * @param puntaje
	 * @return si tiene menos de 17 puntos
	 */
	public boolean verificar17(int puntaje)
	{
		boolean is17 = true;
		
		if(puntaje < 17)
			
			is17 = false;
		
		return is17;	
	}
	
	/**
	 * determina el ganador
	 * @param puntajeOpo
	 * @param puntajeDealer
	 * @return mensaje final
	 */
	public String saberGanador(int puntajeOpo, int puntajeDealer)
	{
		String ganador = "Oponente perdi?";
		
		if(puntajeOpo<=21 && puntajeDealer <=21)
		{
			if(puntajeOpo> puntajeDealer)
			{
				ganador = "Oponente gan?";
			}
			else
			{
				if (puntajeOpo == puntajeDealer)
				{
					ganador = "Empate";
				} else {
					ganador = "Gana dealer";
				}
			}
				
		}
		else 
			{
			if(puntajeOpo <=  21 && puntajeDealer >21)
			{
				ganador = "Oponente gan?";
			}
			else
			{
				if(puntajeDealer<=21 && puntajeOpo>21)
				{
					ganador = "Ganador el dealer";
				} else {
					ganador = "Ambos se pasaron y perdieron";
				}
			}
			}
	
		return ganador;
		
			
	}

	
}