
package ar.edu.unlam.tallerweb1.controladores;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Estadistica;
import ar.edu.unlam.tallerweb1.modelo.ImagenFondo;
import ar.edu.unlam.tallerweb1.modelo.ImagenPersonaje;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
import ar.edu.unlam.tallerweb1.modelo.TablaJugadorRespuesta;
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
	Estadistica mie = new Estadistica();
	Respuesta respuesta = new Respuesta();
	TablaJugadorRespuesta JR = new TablaJugadorRespuesta();
	
	@RequestMapping("/inicio")
	public ModelAndView comenzar()
			
	{
	 	//Guardar Jugador
		ModelMap modelo = new ModelMap();
		mie.setDinero(0);
		mie.setEstres(0);
		mij.setPuntaje(0);
		mie.setRendimiento(0);
		mie.setSocial(0);
		
		//Seteo un jugador a la tabla estadistica
		mie.setJugador(mij);
		
		//Guardo en la BD
		servicioJuego.guardarJugador(mij);
		servicioJuego.guardarEstadisticas(mie);
		
		modelo.put("respuesta", respuesta);
		return new ModelAndView("inicio",modelo);
	}
	
	
	
	@RequestMapping(value = "/mostrarRuta", method = RequestMethod.POST)
	public ModelAndView respuesta(@ModelAttribute("respuesta")Respuesta respuesta, HttpServletRequest request) //Requerido )	
	{
		ModelMap modelo = new ModelMap();
		
		//Consulto las respuestas que dio el jugador
		List<TablaJugadorRespuesta> respuestasAnteriores = servicioJuego.buscarRespuestasAnteriores(mij);
		Long idRespuestaAnterior=(long) 0;
		Long idRtaActual=(long) respuesta.getId();
		Boolean contestada=false;
		Integer red=0;
		
		//verifico si la respuesta actual ya fue contestada o no
		for(TablaJugadorRespuesta i: respuestasAnteriores )
		{
			idRespuestaAnterior=i.getRespuesta().getId();
		  if (idRespuestaAnterior.equals(idRtaActual) ){
				
			  contestada=true;
			
		     }
			
		}
		
		//si fue contestada por el momento lo redirigimos al inicio
		 if (contestada==true ){
				
			return new ModelAndView("redirect:/inicio");
		
	     }
		else{
		
		JR.setJugador(mij);
		
		
		
		JR.setRespuesta(respuesta);
		
		//Guardo JugadorRespuesta en la BD
		servicioJuego.guardarJR(JR);
		
		//Recibo los datos de la respuesta actual
		Respuesta respuestaActual = servicioJuego.buscarRespuesta(respuesta); 
		
		//Recibo Estadisticas del Jugador
		Estadistica objEstadisticas = servicioJuego.estadisticasJugador(mij);
	
		//Consulto nuevamente las respuestas que dio el jugador
		List<TablaJugadorRespuesta> respuestasAnteriores2 = servicioJuego.buscarRespuestasAnteriores(mij);
		
		//Calcular las estadisticas entre los valores de las respuestas que contesto el jugador
		List<Integer> Resultados=servicioJuego.calculoEstadisticas(respuestasAnteriores2,mie);
		
		//Si el jugador ya respondio esa pregunta, no sumar estadisticas
		//Obtengo cada uno de los resultados
		Integer Dinero= Resultados.get(0);
		Integer Estres= Resultados.get(1);
		Integer Social= Resultados.get(2);
		Integer Rendimiento= Resultados.get(3);
				
		
		if(Dinero < 0)
		{
			return new ModelAndView("redirect:/DineroInsuficiente");
		}else{
		
		// Si el jugador selecciono la opcion "Inicio", quiere decir que perdio y lo redirigimos al inicio
		if(respuestaActual.getOpcion().equals("Inicio")){
			return new ModelAndView("redirect:/inicio");
			
		}else{
		//Recibo el objeto pregunta que tenga la ruta asociada a la respuesta elegida por el jugador
		Pregunta siguientePregunta = servicioJuego.buscarPregunta(respuesta) ;

		//Recibo una lista de las siguientes respuestas
		List<Respuesta> miRespuesta = servicioJuego.buscarRespuestas(siguientePregunta);
		
		
		//Traigo la imagen de fondo
		List<ImagenFondo> imgFondo = servicioJuego.buscarImagenDeFondo(siguientePregunta);
		
		for(ImagenFondo i: imgFondo)
		{
		
			//Paso la img de fondo a la vista
			modelo.put("imagenDeFondo", i.getNombreImgFondo());
			
			
			
		}
		
		//Traigo las imagenes de los personajes
				List<ImagenPersonaje> imgPersonajes = servicioJuego.buscarImagenesDePersonajes(siguientePregunta); 
		
				//Paso la img de los personajes a la vista
				modelo.put("listaDePersonajes", imgPersonajes);
				
	
		//Validamos que el jugador pierda el juego
		if((Estres >= 100) || (Rendimiento < 20) || (Rendimiento<20 && Social>70)){
			Long UltimaPregunta_id=(long) 0;
			
			//Si supera el 100% de estres pierde el juego por un colapso de estres
			if(Estres >= 100)
					{ 
						UltimaPregunta_id=(long) 400;
					}
			else 
				//Si su rendimiento es menor que 20 pierde el juego
				if(Rendimiento<20)
					{
						UltimaPregunta_id=(long) 500;
					}
			
			else 
				//Si su rendimiento es menor que 20 pero su vida social es alta
				//pierde el juego pero es popular
				if( (Rendimiento<20 && Social>70))
					{
						UltimaPregunta_id=(long) 600;
					}
			
			//Muestro en la vista que perdio por x motivo
			Pregunta GameOver = servicioJuego.mostrarGameOver(UltimaPregunta_id) ;

			//Recibo una lista de las siguiente respuesta final
			List<Respuesta> opcionFinal = servicioJuego.buscarRespuestas(GameOver);

			
			//Paso la lista de opciones a la vista
			modelo.put("listaR", opcionFinal);
			modelo.put("pregunta", GameOver);
			
			//servicioJuego.reiniciarPartida( respuestaActual, objJugador);
			
		}else{
			//sino, Paso la lista de opciones a la vista para que siga jugando
			modelo.put("listaR", miRespuesta);
			modelo.put("pregunta", siguientePregunta);
			modelo.put("respuesta", respuesta);

		}
		
	
			//Paso a la vista los resultados de las estadisticas
				modelo.put("rendimiento", Rendimiento);
				modelo.put("estres", Estres);
				modelo.put("social", Social);
				modelo.put("dinero", Dinero);
		
					
		
		}
	}
		return new ModelAndView("juego2",modelo);
	     }	
	}
