package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;

public class OrdenPorPatente implements Comparator<Vehiculo>{

	@Override
	public int compare(Vehiculo vehiculoUno, Vehiculo vehiculoDos) {
		
		return vehiculoUno.getPatente().compareTo(vehiculoDos.getPatente());
	}

}
