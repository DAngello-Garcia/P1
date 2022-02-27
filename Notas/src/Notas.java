import javax.swing.JOptionPane;

public class Notas {
	public static void main(String args[]) {
		
	}
	
	public static double leerDouble(String mensaje)
	{
		double dato = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
		return dato;
	}
	
	public static void imprimir(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static double calcularDef(double n1, double n2, double p1, double p2) {
		double def = (n1*p1/100) + (n2*p2/100);
		return def;
	}
	
	public static boolean saberSiGano(double def) {
		boolean r = false;
		if(def > 3) {
			r = true;
		}
		return r;
	}
	
	public static double hallarNotaMayor(double n1, double n2, double n3) {
		double mayor = n1;
		if(mayor < n2) {
			mayor = n2;
		}
		if(mayor < n3) {
			mayor = n3;
		}
		if(n2 < n3) {
			mayor = n3;
		}
		return mayor;
	}
	
}
