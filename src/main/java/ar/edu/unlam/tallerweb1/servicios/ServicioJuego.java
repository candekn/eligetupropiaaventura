package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Objects;

import ar.edu.unlam.tallerweb1.modelo.ImagenPersonaje;
import ar.edu.unlam.tallerweb1.modelo.Estadistica;
import ar.edu.unlam.tallerweb1.modelo.ImagenFondo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.TablaJugadorRespuesta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface ServicioJuego {
	
	
	void guardarJugador(Jugador jugador);
	 
	 TablaJugadorRespuesta guardarJugadoryRespuestaEnJR(Jugador mij, Respuesta respuesta, TablaJugadorRespuesta jR);
	 
	 Estadistica estadisticasJugador(Jugador mij);

	 Pregunta buscarPregunta(Respuesta rta);

	List<Respuesta> buscarRespuestas(Pregunta siguientePregunta);

	Respuesta buscarRespuesta(Respuesta respuesta);

	Estadistica calcularEstadisticas(Respuesta respuestaActual,Estadistica objEstadisticas);

	Pregunta mostrarGameOver(Long id);

	void reiniciarPartida(Respuesta respuestaActual, Estadistica objEstadistica, TablaJugadorRespuesta objJR);

	void actualizarEstadisticas(Estadistica mie);

	void guardarJR(TablaJugadorRespuesta jRconJugadoryRespuesta);

	void guardarEstadisticas(Estadistica mie);

}
