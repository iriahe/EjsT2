package ejRGC1;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Archivo> archivos; // Archivos directos en esta carpeta
	private List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta
	
	public Carpeta (String nombre) {
		this.nombre = nombre;
		this.archivos = new ArrayList<>();
		this.subcarpetas = new ArrayList<>();
		
	}
	public List<Archivo> getArchivos () { return this.archivos; }
	public List<Carpeta> getSubcarpetas () { return this.subcarpetas; }

	public static double calcularPesoTotal(Carpeta inicio) {
		double pesoTot = 0;
		List<Archivo> subArchivos = inicio.getArchivos();
		List<Carpeta> subSubCar = inicio.getSubcarpetas();
		
		//caso base (se puede suprimir)
		if(subArchivos.isEmpty() && subSubCar.isEmpty()) {
			return 0;
		}
		//caso recursivo
		if(subArchivos.size() != 0) {
			for(Archivo arch : subArchivos) {
				pesoTot = pesoTot + arch.getPesoMB();
			} 
		}
		
		if(subSubCar.size() != 0) {
			for(Carpeta car : subSubCar){
				pesoTot = pesoTot + calcularPesoTotal(car);
			}
		} 
		return pesoTot;
	}
	
	public static void main(String args[]) {
		
		Archivo arch1 = new Archivo("arch1",50);
		Archivo arch2 = new Archivo("arch2",10);
		Archivo arch3 = new Archivo("arch3",10);
		Archivo arch4 = new Archivo("arch4",20);
		Carpeta eras = new Carpeta("eras");
		Carpeta debut = new Carpeta("debut");
		Carpeta fearless = new Carpeta("fearless");
		Carpeta speakNow = new Carpeta("speakNow");
		Archivo ourSong = new Archivo("ourSong",20);
		Archivo coldAsYou = new Archivo("coldAsYou",20);
		Archivo haunted = new Archivo("haunted",30);
		
		
		List<Archivo> archivs = new ArrayList<>();
		List<Carpeta> folders = new ArrayList<>();
		List<Archivo> archivsDebut = new ArrayList<>();
		List<Archivo> archivsSpeakNow = new ArrayList<>();
		
		archivsDebut.add(coldAsYou);
		archivsDebut.add(ourSong);
		debut.archivos=archivsDebut;
		archivsSpeakNow.add(haunted);
		speakNow.archivos=archivsSpeakNow;
		folders.add(debut);
		folders.add(fearless);
		folders.add(speakNow);
		eras.subcarpetas=folders;
		
		archivs.add(arch1);
		archivs.add(arch2);
		archivs.add(arch3);
		archivs.add(arch4);
		eras.archivos=archivs;
		
		
		System.out.println("El peso total de eras es "+ calcularPesoTotal(eras));
		
		
		
		
	}
}
