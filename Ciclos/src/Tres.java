import javax.swing.JOptionPane;

public class Tres {
	/*
	 * Construya un algoritmo que dado un número n, calcule el resultado de la serie:
	1- ½+ 1/3 – 1/4+ 1/5 + … +1/n
	 */
	public static void main(String[] args) {
		int n = leerEntero("Ingrese el número: ");
		double r = calcularSerie(n);
		imprimir(""+r);
	}
	
	public static int leerEntero(String mensaje) {
		int n = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return n;
	}
	
	public static void imprimir(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static double calcularSerie(int n) {
		double serie = 1;
		for(int i = 2; i <= n; i++) {
			if(i % 2 == 0) {
				serie -= 1.0/i;
			}else {
				serie += 1.0/i;
			}
		}
		return serie;
	}

}
