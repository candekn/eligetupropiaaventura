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

import ar.edu.unlam.tallerweb1.modelo.Estadistica;
import ar.edu.unlam.tallerweb1.modelo.ImagenFondo;
import ar.edu.unlam.tallerweb1.modelo.ImagenPersonaje;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.TablaJugadorRespuesta;
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
	public void guardarEstadistica(Estadistica mie)
	{
		final Session session = sessionFactory.getCurrentSession();
		session.save(mie);
	}

	@Override
	public Estadistica estadisticasJugador(Jugador mij) {
		
		Long id = (Long) mij.getId();
		final Session session = sessionFactory.getCurrentSession();	
        return (Estadistica) session.createCriteria(Estadistica.class)
				.add(Restrictions.eq("jugador.id",id))
				.uniqueResult();
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


	@Override
	public void guardarJR(TablaJugadorRespuesta jr) {
		final Session session = sessionFactory.getCurrentSession();
		
		session.save(jr);
	}


	@Override
	public void actualizarEstadisticas(Estadistica mie) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(mie);
		
	}


	@Override
	public void guardarEstadisticas(Estadistica mie) {
	final Session session = sessionFactory.getCurrentSession();
		
		session.save(mie);
		
	}
	
	@Override
	public List<TablaJugadorRespuesta> buscarRespuestasAnteriores(Jugador mij) {
final Session session = sessionFactory.getCurrentSession();
		
		Long id = (Long) mij.getId();
		
		List<TablaJugadorRespuesta> misP = session.createCriteria(TablaJugadorRespuesta.class)
				.createAlias("jugador", "jug")
				.add(Restrictions.eq("jug.id", id))
				
				.list();
		
		return misP;
	}


//	@Override
//	public ImagenFondo buscarImagenDeFondo(Pregunta siguientePregunta) {
//		final Session session = sessionFactory.getCurrentSession();	
//		
//		return (ImagenFondo) session.createCriteria(ImagenFondo.class)
//									.createAlias("pregunta", "Tabla")
//									.add(Restrictions.eq("Tabla.id", siguientePregunta.getId()))
//									.uniqueResult();
//		 
//				
//	}
	
	@Override
	public List<ImagenFondo> buscarImagenDeFondo(Pregunta siguientePregunta) {
		final Session session = sessionFactory.getCurrentSession();	
		
		List<ImagenFondo> miF = session.createCriteria(ImagenFondo.class)
									.createAlias("pregunta", "Tabla")
									.add(Restrictions.eq("Tabla.id", siguientePregunta.getId()))
									.list();
		 
				return miF;
	}


	@Override
	public List<ImagenPersonaje> buscarImagenesDePersonajes(Pregunta siguientePregunta) {
		final Session session = sessionFactory.getCurrentSession();
		
		//Long id = mif.getId();
		
		
		List<ImagenPersonaje> misP = session.createCriteria(ImagenPersonaje.class)
				.createAlias("preguntas", "p")
				.add(Restrictions.eq("p.id", siguientePregunta.getId()))
				.list();
		
		return misP;
	}


}

