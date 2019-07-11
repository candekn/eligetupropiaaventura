package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
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
import ar.edu.unlam.tallerweb1.modelo.TablaJugadorExamen;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

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
	public void guardarEstadisticas(Estadistica mie) {
	final Session session = sessionFactory.getCurrentSession();
		
		session.save(mie);
		
		
	}


/**/	
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
		
		List<ImagenPersonaje> misP = session.createCriteria(ImagenPersonaje.class)
				.createAlias("preguntas", "p")
				.add(Restrictions.eq("p.id", siguientePregunta.getId()))
				.list();
		
		return misP;
	}

	@Override
	public Pregunta buscarPreguntaAnterior(Respuesta ultRespuesta) {
		final Session session = sessionFactory.getCurrentSession();
		
		
		 return (Pregunta) session.createCriteria(Pregunta.class)
				 .createAlias("respuesta", "listRespuestas")
					.add(Restrictions.eq("listRespuestas.id",ultRespuesta.getId()) )
					.uniqueResult();
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


	@Override
	public Respuesta buscarRespuestaB(Long segundaOpcion) {
		final Session session = sessionFactory.getCurrentSession();
		
		 return (Respuesta) session.createCriteria(Respuesta.class)
					.add(Restrictions.eq("id",segundaOpcion) )
					.uniqueResult();
	}


	@Override
	public TablaJugadorRespuesta eliminarLaRespuestaDeLaTablaJR(Long id_ultimaRespuesta) {
		final Session session = sessionFactory.getCurrentSession();
		
		
		TablaJugadorRespuesta jr =(TablaJugadorRespuesta) session.createCriteria(TablaJugadorRespuesta.class)
				.createAlias("respuesta", "rta")
				.add(Restrictions.eq("rta.id", id_ultimaRespuesta));
		//session.delete(jr);
		return jr;
		
	}


	@Override
	public void eliminarLaRespuestaDeJR(Long id_ultimaRespuesta) {
final Session session = sessionFactory.getCurrentSession();
		
List<TablaJugadorRespuesta> jr = session.createCriteria(TablaJugadorRespuesta.class)
				.createAlias("respuesta", "rta")
				.add(Restrictions.eq("rta.id", id_ultimaRespuesta))
				.list();
Respuesta rta;
for(TablaJugadorRespuesta j: jr)
{	
	 
	rta=j.getRespuesta();
	session.delete(rta);
}
		
	}




	
	@Override
	public void actualizarEstadisticas(Integer dinero, Integer estres, Integer social, Integer rendimiento, Estadistica mie) {
		final Session session = sessionFactory.getCurrentSession();
		
		mie.setDinero(dinero);
		mie.setEstres(estres);
		mie.setSocial(social);
		mie.setRendimiento(rendimiento);
		
		session.update(mie);
		
	}

	@Override
	public ArrayList<TablaJugadorExamen> traerMejores(){
		final Session session = sessionFactory.getCurrentSession();
		ArrayList<TablaJugadorExamen> mejores = (ArrayList<TablaJugadorExamen>) session.createCriteria(TablaJugadorExamen.class)
												.addOrder(Order.desc("nota"))
												.setMaxResults(10)
												.list();
		return mejores;
	}



	/*
	@Override
	public List<Respuesta> buscarRespuestasAnteriores(Jugador mij) {
		final Session session = sessionFactory.getCurrentSession();
		
		Long id = (Long) mij.getId();
		
		List<Respuesta> misP = session.createCriteria(Respuesta.class)
				.createAlias("tablajr", "jr")
				.createAlias("jr.jugador", "jug")
				.add(Restrictions.eq("jug.id", id))
				
				.list();
		
		return misP;
	}
*/


}
