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
import ar.edu.unlam.tallerweb1.modelo.Jugador;


public interface ServicioJuego {
	
	
	void guardarJugador(Jugador jugador);
	 
	 TablaJugadorRespuesta guardarJugadoryRespuestaEnJR(Jugador mij, Respuesta respuesta, TablaJugadorRespuesta jR);
	 
	 Estadistica estadisticasJugador(Jugador mij);

	 Pregunta buscarPregunta(Respuesta rta);

	List<Respuesta> buscarRespuestas(Pregunta siguientePregunta);

	Respuesta buscarRespuesta(Respuesta respuesta);

	Pregunta mostrarGameOver(Long id);

	void reiniciarPartida(Respuesta respuestaActual, Estadistica objEstadistica, TablaJugadorRespuesta objJR);

	void guardarJR(TablaJugadorRespuesta jRconJugadoryRespuesta);

/**/void guardarEstadisticas(Estadistica mie);

	List<ImagenFondo> buscarImagenDeFondo(Pregunta siguientePregunta);

	List<ImagenPersonaje> buscarImagenesDePersonajes(Pregunta siguientePregunta);

	
	
	List<Integer> calculoEstadisticas(List<TablaJugadorRespuesta> respuestasAnteriores, Estadistica mie);
	
	List<TablaJugadorRespuesta> buscarRespuestasAnteriores(Jugador mij);

	Respuesta buscarRespuestaB(Long segundaOpcion);
	
Pregunta buscarPreguntaAnterior(Respuesta ultRespuesta);

TablaJugadorRespuesta eliminarLaRespuestaDeLaTablaJR(Long id_ultimaRespuesta);

void eliminarLaRespuestaDeJR(Long id_ultimaRespuesta);

void actualizarEstadisticas(Integer dinero, Integer estres, Integer social, Integer rendimiento, Estadistica mie);


	
	//Estadistica calcularEstadisticas(Respuesta respuestaActual,Estadistica objEstadisticas);
	//void actualizarEstadisticas(Estadistica mie); **por ahora no persistimos las estadisticas
}
