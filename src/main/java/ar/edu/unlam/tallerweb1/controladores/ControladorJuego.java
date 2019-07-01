package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioJuego;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorJuego {

	@Inject
	private ServicioJuego servicioJuego;

	Jugador mij = new Jugador();

	@RequestMapping("/inicio")
	public ModelAndView comenzar()
			
	{
	 	//Guardar Jugador
		ModelMap modelo = new ModelMap();
		mij.setDinero(0);
		mij.setEstres(0);
		mij.setPuntaje(0);
		mij.setRendimiento(0);
		mij.setSocial(0);
		Respuesta respuesta = new Respuesta();
		servicioJuego.guardarJugador(mij);
		modelo.put("respuesta", respuesta);
		return new ModelAndView("inicio",modelo);
	}

	
	
	@RequestMapping(value = "/mostrarRuta", method = RequestMethod.POST)
	public ModelAndView respuesta(@ModelAttribute("respuesta")Respuesta respuesta, HttpServletRequest request) //Requerido )	
	{
		ModelMap modelo = new ModelMap();
	
		//Recibo los datos de la respuesta actual
		Respuesta respuestaActual = servicioJuego.buscarRespuesta(respuesta); 
		if(respuestaActual.getOpcion().equals("Inicio")){
			return new ModelAndView("redirect:/inicio");
			
		}else{
		//Recibo el objeto pregunta que tenga la ruta asociada a la respuesta elegida por el jugador
		Pregunta siguientePregunta = servicioJuego.buscarPregunta(respuesta) ;

		//Recibo una lista de las siguientes respuestas
		List<Respuesta> miRespuesta = servicioJuego.buscarRespuestas(siguientePregunta);
		
		//Recibo jugador
		Jugador objJugador = servicioJuego.estadisticasJugador();
	
		
		Jugador objJugadorConEstadisticas=servicioJuego.calcularEstadisticas(respuestaActual, objJugador);
		
		//Si supera el 100% de estres o de social pierde el juego
		if((objJugadorConEstadisticas.getEstres()>=100) || (objJugadorConEstadisticas.getRendimiento()<20) || (objJugadorConEstadisticas.getRendimiento()<20 && objJugadorConEstadisticas.getSocial()>70)){
			Long id=(long) 0;
			if(objJugadorConEstadisticas.getEstres()>=100)
					{ id=(long) 4;
					}
			else if(objJugadorConEstadisticas.getRendimiento()<20)
					{
						id=(long) 5;
					}
			
			else if( (objJugadorConEstadisticas.getRendimiento()<20 && objJugadorConEstadisticas.getSocial()>70))
					{
						 id=(long) 6;
					}
			//Recibo el objeto pregunta que tenga la ruta asociada a la respuesta elegida por el jugador
			Pregunta GameOver = servicioJuego.mostrarGameOver(id) ;

			//Recibo una lista de las siguientes respuestas finales
			List<Respuesta> opcionFinal = servicioJuego.buscarRespuestas(GameOver);
			
			
			//Paso la lista de opciones a la vista
			modelo.put("listaR", opcionFinal);
			modelo.put("pregunta", GameOver);
			//servicioJuego.reiniciarPartida( respuestaActual, objJugador);
			
		}else{
			//Paso la lista de opciones a la vista
			modelo.put("listaR", miRespuesta);
			modelo.put("pregunta", siguientePregunta);
			//Metodo para guardar la partida					
			servicioJuego.guardarPartida(objJugadorConEstadisticas);
			modelo.put("respuesta", respuesta);

		}
		servicioJuego.guardarPartida(objJugadorConEstadisticas);
	
			//Paso a la vista los resultados
				modelo.put("rendimiento", objJugadorConEstadisticas.getRendimiento());
				modelo.put("estres", objJugadorConEstadisticas.getEstres());
				modelo.put("social", objJugadorConEstadisticas.getSocial());
				modelo.put("dinero", objJugadorConEstadisticas.getDinero());
		
					
		
		}
		return new ModelAndView("juego2",modelo);
		
	}
	

}
