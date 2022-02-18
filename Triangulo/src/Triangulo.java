import javax.swing.JOptionPane;

public class Triangulo {
	public static void main(String args[])
	{
		double base = leerDouble("Ingrese la base: ");
		double altura = leerDouble("Ingrese la altura: ");
		double area = calcularArea(base, altura);
		double hipotenusa = hallarHipotenusa(base, altura);
		imprimir("El área del triángulo es: "+ area);
		imprimir("La hipotenusa del triángulo es: "+ hipotenusa);
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
	
	public static double calcularArea(double base, double altura)
	{
		double area = (base*altura)/2;
		return area;
	}
	
	public static double hallarHipotenusa(double base, double altura)
	{
		double hipotenusa = Math.sqrt(Math.pow((base/2), 2) + Math.pow(altura, 2));
		return hipotenusa;
	}
}