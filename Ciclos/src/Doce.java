
public class Doce {
	/*
	 * Haga un método para descomponer un número en sus factores primos.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isPrimo(int n) {
		int i = 0, c = 0;
		boolean primo = true;
		while(i < n/2) {
			if(n%i == 0) {
				c++;
			}
			i++;
		}
		if(c != 1) {
			primo = false;
		}
		return primo;
	}
	
	public static String descomponerFactPrimos(int n) {
		String d = "";
		boolean p = isPrimo(n);
		if(!p) {
			
		} else {
			d += n;			
		}
		
		return d;
	}
	
}
