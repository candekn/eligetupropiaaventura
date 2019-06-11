package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.JuegoDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Opcion;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Ruta;
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
	public Respuesta consultarCodigoRuta(String rta){
		return juegoDao.consultarCodigoRuta(rta);
	}
	
	@Override
	public Ruta mostrarRuta(Long codigoRut){
		return juegoDao.mostrarRuta(codigoRut);
	}
	
	
	@Override
	public void guardarPartida(Jugador mij)
	{
		juegoDao.guardarPartida(mij);
	}

	@Override
	public Jugador estadisticasJugador(Jugador mij) {
		
		return juegoDao.estadisticasJugador(mij);
	}
}
