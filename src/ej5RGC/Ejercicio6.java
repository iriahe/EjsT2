package ej5RGC;

public class Ejercicio6 {
	
	
	public static boolean esPalindromo (String texto) {
		
		//caso base
		if(texto == null || texto.length()<=1) {
			return true;
		}
		//caso recursivo
		if(texto.charAt(0) == texto.charAt(texto.length() -1)){
			return esPalindromo(texto.substring(1,texto.length()-1));
		}
		return false;
		
	}
	public static void main(String args[]) {
		

		System.out.println("Poop es palindromo: " + esPalindromo("poop"));
		System.out.println("coche es palindromo: " + esPalindromo("coche"));
		System.out.println("oso es palindromo: " + esPalindromo("oso"));
		System.out.println("Reconocer es palindromo: " + esPalindromo("reconocer"));

		
		
		
		
	}
}
