package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Objects;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Opcion;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Ruta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface ServicioJuego {
	
	
	 void guardarJugador(Jugador jugador);
	 
     Respuesta consultarCodigoRuta(String rta);
	
	Ruta mostrarRuta(Long codigoRut);
	 
	 void guardarPartida(Jugador mij);
	 
	 Jugador estadisticasJugador(Jugador mij);
	 
	 
}
