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
	
	
}
