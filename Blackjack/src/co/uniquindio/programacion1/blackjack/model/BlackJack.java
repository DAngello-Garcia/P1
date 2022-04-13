package co.uniquindio.programacion1.blackjack.model;
import java.util.ArrayList;
import javax.swing.ImageIcon;

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
final  int REVERSO = 52;
private ArrayList <Integer> cartas;

/**
 * Metodo para reservarle memoria al ArrayList
 */
public BlackJack()
{
cartas= new ArrayList<>();	
}

/**
 * Permite agregar una carta 
 * @param n El numero de la carta
 */
public void agregarCarta(int n)
{
cartas.add(n);	
}

/**
 * Sólo a modo de ejemplo para copiar
 * lo que hay en un arreglo a un Arraylist
 * @param cartas1 El arreglo a copiar
 */
public void iniciarEnsayo(int cartas1[])
{
	for (int i=0; i<cartas1.length; i++)
	{
		cartas.add(cartas1[i]);
	}
}

/**
 * Devuelve el Arraylist con las cartas ingresadas
 * hasta el momento
 * @return El ArrayList
 */
public ArrayList<Integer> getCartas() {
	return cartas;
}

/**
 * Permite inicializar las cartas con el arraylist
 * recibido por parámetro
 * @param cartas
 */
public void setCartas(ArrayList<Integer> cartas) {
	this.cartas = cartas;
}

/**
 * Permite obtener el tipo de carta
 * @param n El número de la carta 
 * @return El tipo de la carta
 */
public  int obtenerTipoCarta(int n)
{
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
public int obtenerTipoPinta(int n)
{
int tipoPinta;
int tipoCarta=obtenerTipoCarta(n);
tipoPinta = (n - tipoCarta) / MAX_CARTAS_PINTA;
return tipoPinta;
}

/**
 * Permite inicializar el reverso
 * @param n El número de la carta
 */ 
public  void inicializarReverso (int n)
{
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
	return REVERSO;
}

/**
 * Devuelve el número de la carta que está en la posición
 * i
 * @param i La posicion dentro del ArrayList
 * @return El número correspondiente a la carta que está
 * en la posicion
 */
public  int devolverCartaPosicion(int i)
{
	return cartas.get(i);
	
}

	    
}
