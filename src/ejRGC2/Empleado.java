package ejRGC2;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private String nombre;
	private double salario;
	private List<Empleado> subordinados; // Lista de empleados a su cargo
	
	public Empleado (String nombre, double salario) {
		this.nombre = nombre;
		this.salario = salario;
		this.subordinados = new ArrayList<>();
	}
	
	public double getSalario () { return this.salario; }
	public List<Empleado> getSubordinados () { return this.subordinados; }
	
	public static double presupuestoEquipo(Empleado jefe) {
		double presupuesto = 0;
		
		//caso base
		if(jefe.subordinados.isEmpty()) {
			return jefe.getSalario();
		}
		
		//caso recursivo
		for(Empleado e : jefe.getSubordinados()) {
			presupuesto = presupuesto + presupuestoEquipo(e);
		}
		
		return jefe.getSalario() + presupuesto;
		
	}
	
	public static void main(String args[]) {
		
		Empleado ceo = new Empleado("Iria", 500000);
		Empleado director = new Empleado("Taylor", 100000);
		Empleado manager = new Empleado("Lana", 80000);
		Empleado empleado1 = new Empleado("e1",40000);
		Empleado empleado2 = new Empleado("e2",40000);
		Empleado empleado3 = new Empleado("e3",40000);
		
		manager.getSubordinados().add(empleado2);
		manager.getSubordinados().add(empleado3);
		manager.getSubordinados().add(empleado1);
		director.getSubordinados().add(manager);
		ceo.getSubordinados().add(director);
	
		System.out.println("El presupuesto del equipo es " + presupuestoEquipo(ceo));
		//System.out.println("Subordinados: " + manager.subordinados);
	}
	
	
	
}
