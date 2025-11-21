package ej8RGC;

public class NodoLista {
	 
	int dato; 
	NodoLista siguiente; 
	
	public NodoLista() {
		this.dato = 0;
		this.siguiente = null;
	}
	
	public static NodoLista invertirRecursivo (NodoLista actual) {
		
	// Caso base: lista vacía o único elemento
		if (actual == null || actual.siguiente == null) {
			return actual;
		}
	// Paso recursivo:
		NodoLista nuevaCabecera = invertirRecursivo(actual.siguiente);
		actual.siguiente.siguiente = actual;
		actual.siguiente = null;
		return nuevaCabecera;
	
	}
	
	public static NodoLista fusionarListas(NodoLista l1, NodoLista l2) {
		
		//caso base
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		//recursivo
		if(l1.dato<=l2.dato) {
			l1.siguiente = fusionarListas(l1.siguiente,l2);
			return l1;
		}
		else{
			l2.siguiente = fusionarListas(l1,l2.siguiente);
			return l2;
		}
	}
	
	
	
	public static void main(String[] args) {

	    // Crear lista: 1 -> 2 -> 3 -> 4 -> null
	    NodoLista nodo1 = new NodoLista();
	    nodo1.dato = 1;
	    NodoLista nodo2 = new NodoLista();
	    nodo2.dato = 2;
	    NodoLista nodo3 = new NodoLista();
	    nodo3.dato = 3;
	    NodoLista nodo4 = new NodoLista();
	    nodo4.dato = 4;

	    // Conectar nodos
	    nodo1.siguiente = nodo2;
	    nodo2.siguiente = nodo3;
	    nodo3.siguiente = nodo4;

	    // Mostrar lista original
	    System.out.print("Lista original: ");
	    imprimirLista(nodo1);

	    // Invertir lista
	    NodoLista cabezaInvertida = invertirRecursivo(nodo1);

	    // Mostrar lista invertida
	    System.out.print("Lista invertida: ");
	    imprimirLista(cabezaInvertida);
	    
	 // ----- Lista 1: 1 -> 3 -> 5 -----
	    NodoLista l1 = new NodoLista();
	    l1.dato = 1;
	    l1.siguiente = new NodoLista();
	    l1.siguiente.dato = 3;
	    l1.siguiente.siguiente = new NodoLista();
	    l1.siguiente.siguiente.dato = 5;

	    // ----- Lista 2: 2 -> 4 -> 6 -----
	    NodoLista l2 = new NodoLista();
	    l2.dato = 2;
	    l2.siguiente = new NodoLista();
	    l2.siguiente.dato = 4;
	    l2.siguiente.siguiente = new NodoLista();
	    l2.siguiente.siguiente.dato = 6;
	    
	    System.out.print("\nLista 1: ");
	    NodoLista temp1 = l1;
	    while (temp1 != null) {
	        System.out.print(temp1.dato + " ");
	        temp1 = temp1.siguiente;
	    }
	    System.out.print("\nLista 2: ");
	    NodoLista temp2 = l2;
	    while (temp2 != null) {
	        System.out.print(temp2.dato + " ");
	        temp2 = temp2.siguiente;
	    }
	    // Fusionamos
	    NodoLista fusionada = fusionarListas(l1, l2);
	    
	    


	    // Imprimir la lista resultante:
	    System.out.print("\nLista fusionada: ");
	    NodoLista temp = fusionada;
	    while (temp != null) {
	        System.out.print(temp.dato + " ");
	        temp = temp.siguiente;
	    }
	    
	    
	    
	}

	// Método auxiliar para imprimir la lista
	public static void imprimirLista(NodoLista cabeza) {
	    NodoLista actual = cabeza;
	    while (actual != null) {
	        System.out.print(actual.dato + " ");
	        actual = actual.siguiente;
	    }
	    System.out.println();
	}
	

	
}

