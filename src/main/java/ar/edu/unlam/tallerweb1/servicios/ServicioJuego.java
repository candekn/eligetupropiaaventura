package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Objects;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface ServicioJuego {
	
	
	 void guardarJugador(Jugador jugador);
	 
	 void guardarPartida(Jugador mij);
	 
	 Jugador estadisticasJugador(Jugador mij);

	 Pregunta buscarPregunta(Respuesta rta);

	List<Respuesta> buscarRespuestas(Pregunta siguientePregunta);
	 Respuesta buscarRespuesta(Respuesta respuesta);
	 Pregunta mostrarGameOver(Long id);

	void reiniciarPartida(Respuesta respuestaActual, Jugador objJugador);
}
