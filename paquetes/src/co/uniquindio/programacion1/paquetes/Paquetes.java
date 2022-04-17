package co.uniquindio.programacion1.paquetes;

import java.util.*;

import javax.swing.JOptionPane;

public class Paquetes {
	
	public static int leerEntero() {
		int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un número: "));
		return n;
	}
	
	public static double leerDouble() {
		double n = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese un número: "));
		return n;
	}
	
	public static void imprimir(String dato) {
		JOptionPane.showInputDialog(dato);
	}
	
	public static String imprimirListInt(ArrayList<Integer> miA) {
		String r = "";
		for(int i = 0; i < miA.size(); i++) {
			r += miA.get(i);
		}
		
		return r;
	}
	
	public static String imprimirListDouble(ArrayList<Double> miA) {
		String r = "";
		for(int i = 0; i < miA.size(); i++) {
			r += miA.get(i);
		}
		
		return r;
	}

	public static ArrayList <Integer> bubbleSort(ArrayList <Integer> a) {
		int n = a.size(), s = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n-1; j++) {
				if(a.get(j) > a.get(j+1)) {
					s = a.get(j);
					a.set(j, a.get(j+1));
					a.set(j+1, s);
				}
			}
		}
		return a;
	}
	
}
