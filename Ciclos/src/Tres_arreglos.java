import java.util.ArrayList;

public class Tres_arreglos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int contarOcurrencias(int n, ArrayList <Integer> a) {
		int c = 0;
		for(int i = 0; i < a.size(); i++) {
			if(n == (int)a.get(i))
				c++;
		}
		return c;
	}
	
	public static boolean verificarRepetido(int n, ArrayList <Integer> a) {
		boolean r = false;
		int c = contarOcurrencias(n, a);
		if(c > 1)
			r = true;
		return r;
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
