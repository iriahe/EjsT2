package es.upm;

public class Ejercicios {

	//ejercicio 2
	
	public static void ex232(int n) {
		 if (n <= 0) return;
		 System.out.println(n);
		 ex232(n-2);
		 ex232(n-3);
		 System.out.println(n);
		}
	
	//ejercicio 3
	
	public static String ex233(int n) {
		 if (n <= 0) return "";
		 return ex233(n-3) + n + ex233(n-2) + n;
		}
	
	//ejercicio 4: el problema es que al estar el caso base después del paso recursivo va a ser un bucle infinito
	
	public static String ex234(int n) {
		 String s = ex234(n-3) + n + ex234(n-2) + n;
		 if (n <= 0) return "";
		 return s;
		}
	
	//ejercicio 5
	
	public static int misterio(int a, int b) {
		 if (b == 0) return 0;
		 if (b % 2 == 0) return misterio(a+a, b/2);
		 return misterio(a+a, b/2) + a;
		}
	
	public static void main (String args[]) {
		
		//ejercicio 2
		ex232(6);
		
		//ejercicio 3
		System.out.println(ex233(6));
		
		//ejercicio 5
		System.out.println(misterio(2,25));
		System.out.print(misterio(3,11));
	}
	
	
}
