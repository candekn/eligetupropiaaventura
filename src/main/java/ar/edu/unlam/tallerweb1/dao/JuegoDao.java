package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;

public interface JuegoDao {
	
	void guardarJugador(Jugador jugador);
	
	void guardarPartida(Jugador mij);

	Jugador estadisticasJugador(Jugador mij);

	Pregunta buscarPregunta(Respuesta rta);

	List<Respuesta> buscarRespuestas(Pregunta siguientePregunta);
	
		Respuesta buscarRespuesta(Respuesta respuesta);

	Pregunta mostrarGameOver(Long id);
	void guardarPartida(Jugador mij);
	
}
