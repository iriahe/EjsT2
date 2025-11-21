package ej7RGC;

public class Nodo {

	int valor;
	Nodo izq;
	Nodo der;
	
	public Nodo(int valor) {
		this.valor = valor;
		this.izq = null;
		this.der = null;
	}
	
	
	public static boolean esBST (Nodo nodo) {
		return esBSTAux(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean esBSTAux (Nodo nodo, int min, int max) {
		//caso base
		if(nodo==null) {
			return true;
		}
		if(nodo.valor>=max || nodo.valor<=min) {
			return false;
		}
		//caso recursivo
		return esBSTAux(nodo.izq, min, nodo.valor) && esBSTAux(nodo.der,nodo.valor,max);
	}
	public static void main(String[] args) {
	
		Nodo bstValido = new Nodo(10);
	    bstValido.izq = new Nodo(5);
	    bstValido.der = new Nodo(15);
	    bstValido.izq.izq = new Nodo(2);
	    bstValido.izq.der = new Nodo(7);
	    bstValido.der.der = new Nodo(20);

	    System.out.println("Árbol 1 es BST? " + esBST(bstValido)); // Esperado: true
	    Nodo noBST = new Nodo(10);
	    noBST.izq = new Nodo(5);
	    noBST.der = new Nodo(8);

	    System.out.println("Árbol 2 es BST? " + esBST(noBST)); // Esperado: false
	}
	}
	

