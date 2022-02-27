import javax.swing.JOptionPane;

public class Mascota {
	public static void main(String args[])
	{
		double a, areaMascota, areaSombreada;
		a = leerDouble("Ingrese el valor de a: ");
		areaMascota = calcularAreaTotalMascota(a);
		areaSombreada = calcularAreasombreada(a);
		imprimir("El área de la mascota es igual a: "+areaMascota+"\nEl área sombreada es igual a: "+areaSombreada);
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
	
	/**
	 * Calcula el área de un rectángulo
	 * @param largo
	 * @param ancho
	 * @return área de un rectángulo
	 */
	public static double calcularAreaRectangulo(double largo, double ancho)
	{
		double area = largo*ancho;
		return area;
	}
	
	/**
	 * Calcula el área de un cuadrado
	 * @param lado
	 * @return área de un cuadrado
	 */
	public static double calcularAreaCuadrado(double lado)
	{
		double area = lado*lado;
		return area;
	}
	
	/**
	 * Calcula el área de un triángulo
	 * @param base
	 * @param altura
	 * @return
	 */
	public static double calcularAreaTriangulo(double base, double altura)
	{
		double area = (base*altura)/2;
		return area;
	}
	
	/**
	 * Calcula el área de la cabeza de la mascota
	 * @param a
	 * @return área de la cabeza
	 */
	public static double calcularAreaCabeza(double a)
	{
		double area, areaOrejas, areaOjos, areaBoca;
		areaOrejas = 2*calcularAreaRectangulo((a/8)+0.7, a/2);
		areaOjos = calcularAreaRectangulo(a/8, 1.5);
		areaBoca = calcularAreaRectangulo(a/8, a/4);
		area = areaOrejas + areaBoca + areaOjos;
		return area;
	}
	
	/**
	 * Calcula el área del cuerpo de la mascota
	 * @param a
	 * @return área del cuerpo
	 */
	public static double calcularAreaCuerpo(double a)
	{
		double area, areaCuerpo, areaBrazos;
		double alturaC = Math.sqrt(Math.pow((a/8)+1, 2) - Math.pow(a/8, 2));
		areaBrazos = calcularAreaTriangulo(0.7, a/8);
		areaCuerpo = calcularAreaTriangulo(a/8, alturaC);
		area = (2*areaBrazos) + areaCuerpo;
		return area;
	}
	
	public static double calcularAreaTotalMascota(double a)
	{
		double area, areaCabeza, areaCuerpo;
		areaCabeza = calcularAreaCabeza(a);
		areaCuerpo = calcularAreaCuerpo(a);
		area = areaCabeza + areaCuerpo;
		return area;
	}
	
	public static double calcularAreasombreada(double a)
	{
		double area, areaR, areaMascota;
		areaMascota = calcularAreaTotalMascota(a);
		areaR = calcularAreaRectangulo(a-1, a+1.5);
		area = areaR - areaMascota;
		return area;
	}
}
