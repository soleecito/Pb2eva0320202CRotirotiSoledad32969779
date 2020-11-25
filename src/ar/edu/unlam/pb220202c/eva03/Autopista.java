package ar.edu.unlam.pb220202c.eva03;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	public Autopista () {
		
		this.telepase = new HashMap <Integer, Vehiculo>();
		this.vehiculosEnCirculacion = new HashSet <Vehiculo>();
		
	}
	
	public Boolean registrarTelepase (Integer numeroTelepase, Vehiculo vehiculo) {
		
		if (!telepase.containsKey(numeroTelepase)) {
			telepase.put(numeroTelepase, vehiculo);
			return true;
		}else {
			return false;
		}
		
	}
	
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFoundException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista
		Boolean pudoIngresar = false;
		
		if (!telepase.containsKey(numeroTelepase)) {
			throw new VehiculoNotFoundException ("El vehiculo no esta registrado");
		}else {
			Vehiculo vehiculoAIngresarALaAutopista = telepase.get(numeroTelepase);
			vehiculosEnCirculacion.add(vehiculoAIngresarALaAutopista);
			pudoIngresar = true;
		}
		return pudoIngresar;
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFoundException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		
		if (!vehiculosEnCirculacion.contains(vehiculo)) {
			throw new VehiculoNotFoundException ("El vehiculo no esta registrado");
		}else {
			vehiculosEnCirculacion.remove(vehiculo);
		}
		
	}
	
	private Set<Vehiculo> obtenerVehiculosConExcesosDeVelocidad(){
		
		Set <Vehiculo> vehiculosConExcesoDeVelocidad = new HashSet <Vehiculo>();
		
		for (Vehiculo vehiculo : vehiculosEnCirculacion) {
			if (vehiculo.enInfraccion()) 
				vehiculosConExcesoDeVelocidad.add(vehiculo);
		}
		
		return vehiculosConExcesoDeVelocidad;
		
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		
		Set <Vehiculo> vehiculosConExcesoDeVelocidad = obtenerVehiculosConExcesosDeVelocidad();
		
		OrdenPorPatente orden = new OrdenPorPatente();
		TreeSet <Vehiculo> ordenadosPorPatente = new TreeSet <Vehiculo> (orden);
		ordenadosPorPatente.addAll(vehiculosConExcesoDeVelocidad);
		
	return ordenadosPorPatente;
	
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return vehiculosEnCirculacion.size();
	}
}
