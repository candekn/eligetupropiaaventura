package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JuegoDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

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
	public void guardarPartida(Jugador mij)
	{
		juegoDao.guardarPartida(mij);
	}

	@Override
	public Jugador estadisticasJugador() {
		
		return juegoDao.estadisticasJugador();
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
	
	@Override
	public void reiniciarPartida(Respuesta respuestaActual, Jugador objJugador) {
		Long id=(long) 100;
		objJugador.setUltimaRespuesta(id);

		objJugador.setRendimiento(0);
		objJugador.setDinero(0);
		objJugador.setSocial(0);
		objJugador.setEstres(0);
	}
	
	/**/
	@Override
	public List<Jugador> buscarJugadores()
	{
		return juegoDao.buscarJugadores();
	}
	
	@Override
	public Jugador calcularEstadisticas(Respuesta respuestaActual, Jugador objJugador){
		Integer rendimiento=0;
		Integer estres=0;
		Integer social=0;
		Integer dinero=0;
		
		
		//Suma lo que tenia, mas, el valor de la respuesta
		 rendimiento= respuestaActual.getRendimiento()+objJugador.getRendimiento();
		 estres= respuestaActual.getEstres()+objJugador.getEstres();
		 social= respuestaActual.getSocial()+objJugador.getSocial();
		 dinero= respuestaActual.getDinero()+objJugador.getDinero();
 
		objJugador.setUltimaRespuesta(respuestaActual.getId());

		objJugador.setRendimiento(rendimiento);
		objJugador.setDinero(dinero);
		objJugador.setSocial(social);
		objJugador.setEstres(estres);

		return objJugador;
}

	
}
