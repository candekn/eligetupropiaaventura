package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

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
import ar.edu.unlam.tallerweb1.modelo.Opcion;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Ruta;
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
	public Respuesta consultarCodigoRuta(String rta){
		final Session session = sessionFactory.getCurrentSession();	
        return (Respuesta) session.createCriteria(Respuesta.class)
				
				.add(Restrictions.eq("respuesta",rta) )
				.uniqueResult();
	}
	
	@Override
	public Ruta mostrarRuta(Long codigoRut){
		final Session session = sessionFactory.getCurrentSession();	
        return (Ruta) session.createCriteria(Ruta.class)
				
				.add(Restrictions.eq("id",codigoRut) )
				.uniqueResult();
	}
	
	@Override
	public void guardarPartida(Jugador mij)
	{
		final Session session = sessionFactory.getCurrentSession();
		session.update(mij);
	}

	@Override
	public Jugador estadisticasJugador(Jugador mij) {
		
		final Session session = sessionFactory.getCurrentSession();	
        return (Jugador) session.createCriteria(Jugador.class)
				
				.add(Restrictions.eq("id",mij.getId()) )
				.uniqueResult();
	}
}
