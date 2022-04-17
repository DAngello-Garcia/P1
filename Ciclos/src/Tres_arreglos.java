import java.util.ArrayList;

public class Tres_arreglos {

	public static void main(String[] args) {
		ArrayList <Integer> miA = new ArrayList<>();
		ArrayList <Integer> a = new ArrayList<>();
		miA.add(2);
		miA.add(3);
		miA.add(1);
		miA.add(2);
		miA.add(5);
		miA.add(3);
		miA.add(3);
		miA.add(5);
		miA.add(7);
		a = devolverSinRepeticiones(miA);
		System.out.println(""+a.toString());
	}
	
	public static int contarOcurrencias(int n, ArrayList <Integer> a) {
		int c = 0;
		for(int i = 0; i < a.size(); i++) {
			if(n == (int)(a.get(i)))
				c++;
		}
		return c;
	}
	
	public static int hallarMasRepetido(ArrayList <Integer> a) {
		int masR = 0, flag = 0, cont;
		for(int i = 1; i < a.size(); i++) {
			cont = contarOcurrencias(a.get(i), a);
			if(flag < cont)
				flag = cont;
				masR = a.get(i);
		}
		return masR;
	}
	
	public static boolean verificarRepetido(int n, ArrayList <Integer> a) {
		boolean r = false;
		int c = contarOcurrencias(n, a);
		if(c > 0)
			r = true;
		return r;
	}
	
	public static ArrayList <Integer> eliminarMasRepetido(ArrayList <Integer> a) {
		ArrayList <Integer> miA = new ArrayList<>();
		int masR = hallarMasRepetido(a);
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i) != masR) {
				miA.add(a.get(i));
			}
		}
		return miA;
	}
	
	public static ArrayList <Integer> devolverSinRepeticiones(ArrayList <Integer> a) {
		ArrayList <Integer> miA = new ArrayList<>();
		boolean v;
		for(int i = 0; i < a.size(); i++) {
			v = verificarRepetido(a.get(i), miA);
			if(!v)
				miA.add(a.get(i));
		}
		return miA;
	}

}
