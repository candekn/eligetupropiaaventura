package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("JuegoDao")
public class JuegoDaoImpl implements JuegoDao {
	
	@Inject
    private SessionFactory sessionFactory;
		 
	@Override
	public void guardarJugador(Jugador jugador)
	{
		final Session session = sessionFactory.getCurrentSession();
		session.save(jugador);
	}
	
	
	@Override
	public void guardarPartida(Jugador mij)
	{
		final Session session = sessionFactory.getCurrentSession();
		session.update(mij);
	}

	@Override
	public Jugador estadisticasJugador() {
		
		
		final Session session = sessionFactory.getCurrentSession();	
        return (Jugador) session.createCriteria(Jugador.class)
				
				.uniqueResult();
	}

	
	@Override
	public List<Jugador> buscarJugadores() {
		final Session session = sessionFactory.getCurrentSession();	
		
		List<Jugador> listJugador = session.createCriteria(Jugador.class)
									.list();
		return listJugador;
	}
	
	@Override
	public Pregunta buscarPregunta(Respuesta rta) {
		final Session session = sessionFactory.getCurrentSession();	
		
		Long id = rta.getId();
		Respuesta r = (Respuesta) session.createCriteria(Respuesta.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		
		return r.getPreguntaSiguiente();
	}

	@Override
	public List<Respuesta> buscarRespuestas(Pregunta siguientePregunta) {
		final Session session = sessionFactory.getCurrentSession();	
		
		List<Respuesta> respuestas = session.createCriteria(Respuesta.class)
									.add(Restrictions.eq("pregunta", siguientePregunta))
									.list();
		return respuestas;
	}


	@Override
	public Respuesta buscarRespuesta(Respuesta respuesta) {
		final Session session = sessionFactory.getCurrentSession();
		Long id = respuesta.getId();
		 return (Respuesta) session.createCriteria(Respuesta.class)
					.add(Restrictions.eq("id",id) )
					.uniqueResult();
	}


	@Override
	public Pregunta mostrarGameOver(Long id) {
final Session session = sessionFactory.getCurrentSession();	
		
		Pregunta p = (Pregunta) session.createCriteria(Pregunta.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		
		return p;
		
	}






}
