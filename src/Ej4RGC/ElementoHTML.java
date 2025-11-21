package Ej4RGC;

import java.util.ArrayList;
import java.util.List;

public class ElementoHTML {

	private String tag; // Ejemplo: "div", "p", "img"
	private List<ElementoHTML> hijos;
	
	public ElementoHTML(String tag) {
		this.tag = tag;
		this.hijos = new ArrayList<>();
	}
	
	public String getTag () { return this.tag; }
	public List<ElementoHTML> getHijos () { return this.hijos; }
	
	public static int contarEtiquetas (ElementoHTML elemento, String tagBuscado) {
		int count = 0;
		//caso base
		if(elemento.getTag()!=tagBuscado && elemento.getHijos().isEmpty()) {
			return 0;
		}
		//caso recursivo
		if(elemento.getTag().equals(tagBuscado)) {
			count = count + 1;
		}
		for(ElementoHTML hijo : elemento.getHijos()) {
			count = count + contarEtiquetas(hijo, tagBuscado);
		}
		
		return count;
	}
	public static void main(String[] args) {

	    // Crear elementos
	    ElementoHTML div = new ElementoHTML("div");
	    ElementoHTML p1 = new ElementoHTML("p");
	    ElementoHTML span = new ElementoHTML("span");
	    ElementoHTML p2 = new ElementoHTML("p");
	    ElementoHTML img = new ElementoHTML("img");
	    ElementoHTML p3 = new ElementoHTML("p");

	    // Construir árbol
	    // p1 tiene dos hijos
	    p1.getHijos().add(span);
	    p1.getHijos().add(p2);

	    // div tiene p1, img y p3
	    div.getHijos().add(p1);
	    div.getHijos().add(img);
	    div.getHijos().add(p3);

	    // Probar contar etiquetas
	    int numP = contarEtiquetas(div, "p");
	    int numDiv = contarEtiquetas(div, "div");
	    int numImg = contarEtiquetas(div, "img");
	    int numSpan = contarEtiquetas(div, "span");

	    // Mostrar resultados
	    System.out.println("Número de <p>: " + numP + " (esperado: 3)");
	    System.out.println("Número de <div>: " + numDiv + " (esperado: 1)");
	    System.out.println("Número de <img>: " + numImg + " (esperado: 1)");
	    System.out.println("Número de <span>: " + numSpan + " (esperado: 1)");
	}

}
