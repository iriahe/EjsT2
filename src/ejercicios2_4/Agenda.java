package ejercicios2_4;

import java.util.HashMap;

public class Agenda {

	private HashMap<String, Integer> agendas = new HashMap<>();

	
	public Agenda() {
	}
	
	public void entrada(String persona, int telefono) throws Exception{
		if(this.agendas.containsKey(persona)) {
			throw new Exception("Usuario ya dado de alta");
		}
		this.agendas.put(persona, telefono);
	}
	
	public int getTelefono(String persona) throws Exception {
		if(!agendas.containsKey(persona)) {
			throw new Exception("No se ha encontrado a " + persona + " en la agenda");
		}
		return agendas.get(persona);
	}
	
	public static void main(String args[]) {
		
		Agenda miAgenda = new Agenda();
		try {
			miAgenda.entrada("Gaizka", 688687042);
		} catch (Exception e) {
		}
		
		try {
			System.out.println("El telefono de Gaizka es " + miAgenda.getTelefono("Gaizka"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
