package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;

public interface JuegoDao {
	
	void guardarJugador(Jugador jugador);
	
	void guardarPartida(Jugador mij);

	Jugador estadisticasJugador();

	Pregunta buscarPregunta(Respuesta rta);

	List<Respuesta> buscarRespuestas(Pregunta siguientePregunta);

	List<Jugador> buscarJugadores();

	Respuesta buscarRespuesta(Respuesta respuesta);

	Pregunta mostrarGameOver(Long id);
	
}
