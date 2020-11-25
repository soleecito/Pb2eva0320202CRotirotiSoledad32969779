package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

public class TestAutoPista {

	@Test
	public void queSePuedaRegistrarTelepase() {

		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("AAA222", 130, 200);

		assertTrue(autopista.registrarTelepase(123, auto));

	}

	@Test(expected = VehiculoNotFoundException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFoundException {

		Autopista autopista = new Autopista();
		Vehiculo camion = new Camion("BBB333", 100, 150, 2);
		Vehiculo auto = new Automovil("AAA222", 130, 200);

		autopista.registrarTelepase(123, camion);
		autopista.registrarTelepase(124, auto);
		autopista.ingresarAutopista(123);

		autopista.salirAutpista(auto);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = autopista.cantidadDeVehiculosENCirculacion();
		
		assertEquals(valorEsperado, valorObtenido);
		
		
	}

	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente()  {

		Autopista autopista = new Autopista();

		Vehiculo camionUno = new Camion("BBB333", 100, 150, 2);//segundo
		Vehiculo camionDos = new Camion("BBB444", 100, 150, 2);
		Vehiculo autoUno = new Automovil("AAA222", 130, 200);//primero
		Vehiculo autoDos = new Automovil("AAA555", 130, 200);
		Vehiculo autoTres = new Automovil("CCC777", 130, 200);//ultimo
		
		autopista.registrarTelepase(1, autoUno);
		autopista.registrarTelepase(2, autoDos);
		autopista.registrarTelepase(3, autoTres);
		autopista.registrarTelepase(4, camionUno);
		autopista.registrarTelepase(5, camionDos);
		
		autoTres.incrmentarVelocidad(230);
		camionUno.incrmentarVelocidad(200);
		autoUno.incrmentarVelocidad(250);
		
		try {
			autopista.ingresarAutopista(1);
			autopista.ingresarAutopista(2);
			autopista.ingresarAutopista(3);
			autopista.ingresarAutopista(4);
			autopista.ingresarAutopista(5);
		} catch (VehiculoNotFoundException e) {
			e.getMessage();
		}		
		
		TreeSet<Vehiculo> listaDeVehiculosInfractoresOrdenadosPorNombre = autopista
				.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		
		String valorPrimeroEsperado = "AAA222";
		String valorPrimeroObtenido = listaDeVehiculosInfractoresOrdenadosPorNombre.first().getPatente();
		
		String valorUltimoEsperado = "CCC777";
		String valorUltimoObtenido = listaDeVehiculosInfractoresOrdenadosPorNombre.last().getPatente();
		
		assertEquals(valorPrimeroEsperado, valorPrimeroObtenido);
		assertEquals(valorUltimoEsperado, valorUltimoObtenido);

	}
	
	@Test
	public void queNoSePuedaRegistarConUnNumeroDeTelepaseExistente() {
		
		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("AAA222", 130, 200);
		Vehiculo camion = new Camion("BBB444", 100, 150, 2);
		
		autopista.registrarTelepase(1, auto);
		
		assertFalse(autopista.registrarTelepase(1, camion));
		

	}
	
	@Test (expected = VehiculoNotFoundException.class)
	public void queAlIngresarALaAutopistaSinTelepaseLanceUnaExpepction() throws VehiculoNotFoundException {

		Autopista autopista = new Autopista();
		Vehiculo auto = new Automovil("AAA222", 130, 200);
		
		assertFalse(autopista.ingresarAutopista(1));
	}

}
