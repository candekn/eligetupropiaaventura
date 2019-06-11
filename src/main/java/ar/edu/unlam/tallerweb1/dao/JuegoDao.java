package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Opcion;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Ruta;

public interface JuegoDao {
	
	void guardarJugador(Jugador jugador);
	
	public Respuesta consultarCodigoRuta(String rta);
	
	public Ruta mostrarRuta(Long codigoRut);
	
	void guardarPartida(Jugador mij);

	Jugador estadisticasJugador(Jugador mij);
	
}
