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
		mij.setDinero(100);
		mij.setEstres(30);
		mij.setPuntaje(0);
		mij.setRendimiento(50);
		mij.setSocial(30);
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
			
		
		
			Pregunta GameOver = servicioJuego.mostrarGameOver(id) ;

			//Recibo una lista de las siguientes respuestas finales
			List<Respuesta> opcionFinal = servicioJuego.buscarRespuestas(GameOver);
			
			
			//Paso la lista de opciones a la vista
			modelo.put("listaR", opcionFinal);
			modelo.put("pregunta", GameOver);
			//servicioJuego.reiniciarPartida( respuestaActual, objJugador);
		
		
		
		
		
		}else{
		//Recibo el objeto pregunta que tenga la ruta asociada a la respuesta elegida por el jugador
		Pregunta siguientePregunta = servicioJuego.buscarPregunta(respuesta) ;

		//Recibo una lista de las siguientes respuestas
		List<Respuesta> miRespuesta = servicioJuego.buscarRespuestas(siguientePregunta);
		
			}
		return new ModelAndView("juego",modelo);
		
	}
	

}
