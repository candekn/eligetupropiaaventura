package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.ImagenPersonaje;
import ar.edu.unlam.tallerweb1.dao.JuegoDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Estadistica;
import ar.edu.unlam.tallerweb1.modelo.ImagenFondo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.TablaJugadorRespuesta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Service("ServicioJuego")
@Transactional
public class ServicioJuegoImpl implements ServicioJuego {

	@Inject
	private JuegoDao juegoDao;
	
	@Override
	public void guardarJugador(Jugador jugador){
		juegoDao.guardarJugador(jugador);
	}
	
	
	@Override
	public TablaJugadorRespuesta guardarJugadoryRespuestaEnJR(Jugador mij, Respuesta mir, TablaJugadorRespuesta jr)
	{	
		jr.setJugador(mij);
		jr.setRespuesta(mir);
		
		return jr;
		
	}

	@Override
	public Estadistica estadisticasJugador(Jugador mij) {
		
		return juegoDao.estadisticasJugador(mij);
	}

	@Override
	public Pregunta buscarPregunta(Respuesta rta) {
		
		return juegoDao.buscarPregunta(rta) ;
	}


	@Override
	public List<Respuesta> buscarRespuestas(Pregunta siguientePregunta) {
		
		return juegoDao.buscarRespuestas(siguientePregunta);
	}
	
	
	@Override
	public Respuesta buscarRespuesta(Respuesta respuesta) {
		return juegoDao.buscarRespuesta(respuesta);
		
	}
	
	@Override
	public Pregunta mostrarGameOver(Long id) {
		return	juegoDao.mostrarGameOver(id);
		
	}
	
	
	//...
	@Override
	public void reiniciarPartida(Respuesta respuestaActual, Estadistica objEstadistica, TablaJugadorRespuesta objJR) {
		Long id=(long) 100;
		objJR.getRespuesta().setId(id);

		objEstadistica.setRendimiento(0);
		objEstadistica.setDinero(0);
		objEstadistica.setSocial(0);
		objEstadistica.setEstres(0);
	}




	@Override
	public void guardarJR(TablaJugadorRespuesta jr) {
		juegoDao.guardarJR(jr);
		
	}


	@Override
	public void guardarEstadisticas(Estadistica mie) {
		juegoDao.guardarEstadisticas(mie);
		
	}


	@Override
	public List<ImagenFondo> buscarImagenDeFondo(Pregunta siguientePregunta) {
		
		return juegoDao.buscarImagenDeFondo(siguientePregunta);
	}


	@Override
	public List<ImagenPersonaje> buscarImagenesDePersonajes(Pregunta siguientePregunta) {
		return juegoDao.buscarImagenesDePersonajes( siguientePregunta);
	}
/*

	@Override
	public List<Respuesta> buscarRespuestasAnteriores(Jugador mij) {
		
		return juegoDao.buscarRespuestasAnteriores(mij);
	}
*/

	


	@Override
	public List<TablaJugadorRespuesta> buscarRespuestasAnteriores(Jugador mij) {
		return juegoDao.buscarRespuestasAnteriores(mij);
	}


	@Override
	public List<Integer> calculoEstadisticas(List<TablaJugadorRespuesta> respuestasAnteriores, Estadistica mie) {
	
		Integer rendimiento=0;
		Integer estres=0;
		Integer social=0;
		Integer dinero=0;
		
		List<Integer> resultados=new ArrayList<Integer>();
	
		for(TablaJugadorRespuesta j: respuestasAnteriores)
		{	
			//Suma lo que tenia, mas, el valor de la respuesta
			 rendimiento+= j.getRespuesta().getRendimiento();
			 estres+=  j.getRespuesta().getEstres();
			 social+=  j.getRespuesta().getSocial();
			 dinero+=  j.getRespuesta().getDinero();
			 
			
		
		}
			resultados.add(dinero);
			 resultados.add(estres);
			 resultados.add(social);
			 resultados.add(rendimiento);
		
		return resultados;
		
	}



	

	
	
	
/*No lo usamos por ahora
 	
	@Override
	public Estadistica calcularEstadisticas(Respuesta respuestaActual, Estadistica objEstadistica){
		Integer rendimiento=0;
		Integer estres=0;
		Integer social=0;
		Integer dinero=0;
		
		
		//Suma lo que tenia, mas, el valor de la respuesta
		 rendimiento= respuestaActual.getRendimiento()+objEstadistica.getRendimiento();
		 estres= respuestaActual.getEstres()+objEstadistica.getEstres();
		 social= respuestaActual.getSocial()+objEstadistica.getSocial();
		 dinero= respuestaActual.getDinero()+objEstadistica.getDinero();
 
		
		 objEstadistica.setRendimiento(rendimiento);
		 objEstadistica.setDinero(dinero);
		 objEstadistica.setSocial(social);
		 objEstadistica.setEstres(estres);
		 

		return objEstadistica;
}
*/
	
	
	

	

	
}
