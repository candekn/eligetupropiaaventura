package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Jugador;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Jugador consultarJugador(Jugador jugador);
	
	void guardarJugador(Jugador jugador);
}
