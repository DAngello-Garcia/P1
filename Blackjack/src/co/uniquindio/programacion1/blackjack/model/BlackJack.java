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
	 * Devuelve el Arraylist con las cartas que están en el tablero hasta el momento
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
		cartasDealer.add(n);
		return n;
	}
	
	
	/**
	 * asigna valores numéricos a las cartas
	 * @param cartasOpo
	 * @return arraylist con el valor numérico de las cartas
	 */
	public ArrayList<Integer> asignarPuntajeOpo(ArrayList<Integer> cartasOpo) {
		
		ArrayList<Integer> puntaje = new ArrayList<>();
		int numero = 0;
		int as = 0;
		
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
	
	/**
	 * asigna valores numéricos a las cartas
	 * @param cartasDealer
	 * @return arraylist con el valor numérico de las cartas
	 */
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
	public boolean verificar17(ArrayList<Integer> puntaje)
	{
		boolean is17 = true;
		int suma= obtenerPuntaje(puntaje);
		
		if(suma < 17)
			
			is17 = false;
		
		return is17;	
	}
	
	/**
	 * determina el ganador
	 * @param puntajeOpo
	 * @param puntajeDealer
	 * @return mensaje final
	 */
	public String saberGanador(ArrayList<Integer> puntajeOpo, ArrayList<Integer> puntajeDealer)
	{
		int sumaOpo = obtenerPuntaje(puntajeOpo);
		int sumaDealer = obtenerPuntaje(puntajeDealer);
		String ganador = "perdiste";
		
		if(sumaOpo<=21 && sumaDealer <=21)
		{
			if(sumaOpo> sumaDealer)
			{
				ganador = "Felicitaciones";
			}
			else
			{
				if (sumaOpo == sumaDealer)
				{
					ganador = "Empate";
				}
			}
				
		}
		else 
			{
			if(sumaOpo <=  21 && sumaDealer >21)
			{
				ganador = "Felicitaciones";
			}
			else
			{
				if(sumaDealer<=21 && sumaOpo>21)
				{
					ganador = "Ganador el dealer";
				}
			}
			}
	
		return ganador;
		
			
	}
	
	
}