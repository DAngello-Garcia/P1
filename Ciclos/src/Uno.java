import javax.swing.JOptionPane;

public class Uno {
	/*
	 * Construya un algoritmo que genere la tabla de multiplicar de un número n.
	 */
	public static void main(String args[]) {
		int n;
		String tabla;
		n = leerEntero("Ingrese el número: ");
		tabla = calcularTabla(n);
		imprimir(tabla);
	}
	
	public static int leerEntero(String mensaje) {
		int n = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return n;
	}
	
	public static void imprimir(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static String calcularTabla(int n) {
		String tabla = "";
		for(int i = 1; i <= 10; i++) {
			tabla += i+" * "+n+" = "+(i*n)+"\n";
		}
		return tabla;
	}
}
