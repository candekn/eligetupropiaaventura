package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Estadistica;
import ar.edu.unlam.tallerweb1.modelo.ImagenFondo;
import ar.edu.unlam.tallerweb1.modelo.ImagenPersonaje;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.TablaJugadorRespuesta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;

public interface JuegoDao {
	
	void guardarJugador(Jugador jugador);
	
	void guardarEstadistica(Estadistica mie);

	Estadistica estadisticasJugador(Jugador mij);

	Pregunta buscarPregunta(Respuesta rta);

	List<Respuesta> buscarRespuestas(Pregunta siguientePregunta);

	Respuesta buscarRespuesta(Respuesta respuesta);

	Pregunta mostrarGameOver(Long id);

	void guardarJR(TablaJugadorRespuesta jr);

	void guardarEstadisticas(Estadistica mie);

	/**/
	List<ImagenFondo> buscarImagenDeFondo(Pregunta siguientePregunta);

	List<ImagenPersonaje> buscarImagenesDePersonajes(Pregunta siguientePregunta);
	
	Pregunta buscarPreguntaAnterior(Respuesta ultRespuesta);

	List<TablaJugadorRespuesta> buscarRespuestasAnteriores(Jugador mij);

	Respuesta buscarRespuestaB(Long segundaOpcion);

	TablaJugadorRespuesta eliminarLaRespuestaDeLaTablaJR(Long id_ultimaRespuesta);

	void  eliminarLaRespuestaDeJR(Long id_ultimaRespuesta);

	void actualizarEstadisticas(Integer dinero, Integer estres, Integer social, Integer rendimiento, Estadistica mie);

	
	
	
}
