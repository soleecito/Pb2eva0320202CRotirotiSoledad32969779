package ar.edu.unlam.pb220202c.eva03;

public abstract class Vehiculo implements Imultable {

	//Se debe crear contructeres getters y Setters y loos que crean convenientes
	private String patente;
	private Integer velocidadActual;
	private Integer limiteVelocidad;

	public Vehiculo(String patente, Integer velocidadActual, Integer limiteVelocidad) {
		
		this.patente = patente;
		this.velocidadActual = velocidadActual;
		this.limiteVelocidad = limiteVelocidad;
	}

	public void incrmentarVelocidad(Integer velocidad) {
		this.velocidadActual = velocidad;
	}

	public String getPatente() {
		return patente;
	}

	public Integer getVelocidadActual() {
		return velocidadActual;
	}

	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}
	
	
	
}
