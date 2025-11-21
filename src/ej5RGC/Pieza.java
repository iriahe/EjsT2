package ej5RGC;

import java.util.ArrayList;
import java.util.List;

public class Pieza {
	private String nombre;
	private boolean esDefectuosa;
	private List<Pieza> componentes; // Piezas necesarias para montar esta
	
	public Pieza(String nombre, boolean esDefectuosa) {
		this.nombre = nombre;
		this.esDefectuosa = esDefectuosa;
		this.componentes = new ArrayList<>();
		
	}
	public boolean isDefectuosa () { return this.esDefectuosa; }
	public List<Pieza> getComponentes () { return this.componentes; }
	
	public static boolean contieneDefectos (Pieza piezaPrincipal) {
		if(piezaPrincipal == null) {
			return false;
		}
		//caso base
		if(piezaPrincipal.isDefectuosa()) {
			return true;
		}
		
		//caso recursivo
		for(Pieza component : piezaPrincipal.getComponentes()) {
			if(contieneDefectos(component)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

	    // Piezas básicas (sin componentes)
	    Pieza tornillo = new Pieza("Tornillo", false);
	    Pieza tuerca = new Pieza("Tuerca", false);
	    Pieza engranaje = new Pieza("Engranaje", true);  // ESTA ES DEFECTUOSA
	    Pieza polea = new Pieza("Polea", false);

	    // Subconjunto de piezas
	    List<Pieza> componentesMotor = new ArrayList<>();
	    componentesMotor.add(tornillo);
	    componentesMotor.add(tuerca);
	    componentesMotor.add(engranaje);   // <-- pieza defectuosa incluida

	    Pieza motor = new Pieza("Motor", false);
	    motor.getComponentes().addAll(componentesMotor);

	    // Producto completo
	    List<Pieza> componentesMaquina = new ArrayList<>();
	    componentesMaquina.add(motor);
	    componentesMaquina.add(polea);

	    Pieza maquina = new Pieza("Máquina Completa", false);
	    maquina.getComponentes().addAll(componentesMaquina);

	    // PRUEBAS
	    System.out.println("¿El motor tiene defectos? " +
	            contieneDefectos(motor));  // Debe dar TRUE por engranaje

	    System.out.println("¿La máquina tiene defectos? " +
	            contieneDefectos(maquina)); // Debe dar TRUE también

	    // Probando una pieza perfecta
	    Pieza piezaPerfecta = new Pieza("Pieza Aislada", false);
	    System.out.println("¿La pieza aislada tiene defectos? " +
	            contieneDefectos(piezaPerfecta)); // Debe dar FALSE
	}

}
