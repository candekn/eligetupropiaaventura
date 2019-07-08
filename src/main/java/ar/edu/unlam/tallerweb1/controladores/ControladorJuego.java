package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import ar.edu.unlam.tallerweb1.modelo.Pregunta;
import ar.edu.unlam.tallerweb1.modelo.Respuesta;
import ar.edu.unlam.tallerweb1.modelo.TablaJugadorRespuesta;
import ar.edu.unlam.tallerweb1.modelo.Jugador;
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

	// La anotacion @Inject indica a Spring que en este atributo se debe setear (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/home")
	public ModelAndView irAHome() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Jugador jugador = new Jugador();
		modelo.put("jugador", jugador);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("home", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("jugador") Jugador jugador, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a través de la URL correspondiente a ésta
		Jugador jugadorBuscado = servicioLogin.consultarJugador(jugador);
		if (jugadorBuscado != null) {
			request.getSession().setAttribute("NOMBRE", jugadorBuscado.getNombre());
			mij = jugadorBuscado;
			return new ModelAndView("redirect:/inicio");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("home", model);
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path= "/registro", method= RequestMethod.POST)
	public ModelAndView registro(@ModelAttribute("jugador") Jugador jugador, String pass2, HttpServletRequest request){
		ModelMap model = new ModelMap();
		if(0!=pass2.compareTo(jugador.getPassword())){
			model.put("error", "Las contraseña coinciden");
		}else{
			Jugador usuarioBuscado = servicioLogin.consultarJugador(jugador);
			if(usuarioBuscado==null){
				
				
				
				
				
				servicioLogin.guardarJugador(jugador);
				mij = jugador;
				
				mie.setDinero(0);
				mie.setEstres(0);
				mie.setRendimiento(0);
				mie.setSocial(0);
				
				//Seteo un jugador a la tabla estadistica
				mie.setJugador(mij);
				
				//Guardo en la BD
				//servicioJuego.guardarJugador(mij);
				servicioJuego.guardarEstadisticas(mie);
				
		
				
				return new ModelAndView("redirect:/inicio");
				}else{
					model.put("error", "El usuario ya existe");
				}
		}
		return new ModelAndView("home", model);
	}	
	@RequestMapping("/inicio")
	public ModelAndView comenzar()
			
	{
	 	
		ModelMap modelo = new ModelMap();
		
		modelo.put("respuesta", respuesta);
		return new ModelAndView("inicio",modelo);
	}
	
	
	
	@RequestMapping(value = "/mostrarRuta", method = RequestMethod.POST)
	public ModelAndView respuesta(@ModelAttribute("respuesta")Respuesta respuesta) //Requerido )	
	{
		ModelMap modelo = new ModelMap();
		
		//Recibo los datos de la respuesta actual
		Respuesta respuestaActual = servicioJuego.buscarRespuesta(respuesta); 
		if(respuestaActual.getOpcion().equals("Inicio")){
			return new ModelAndView("redirect:/inicio");
			
		}
		//Consulto las respuestas que dio el jugador
		List<TablaJugadorRespuesta> respuestasAnteriores = servicioJuego.buscarRespuestasAnteriores(mij);
		Long idRespuestaAnterior=(long) 0;
		Long idRtaActual=(long) respuesta.getId();
		Boolean contestada=false;
		//Integer red=0;
		
		//verifico si la respuesta actual ya fue contestada o no
		for(TablaJugadorRespuesta i: respuestasAnteriores )
		{
			idRespuestaAnterior=i.getRespuesta().getId();
		  if (idRespuestaAnterior.equals(idRtaActual) ){
				
			  contestada=true;
			
		     }
			
		}
		
		//si fue contestada
		 if (!contestada){
			 
			 JR.setJugador(mij);
				
				JR.setRespuesta(respuesta);
				
				//Guardo JugadorRespuesta en la BD
				servicioJuego.guardarJR(JR);
			 
				
				
				//Recibo Estadisticas del Jugador
				Estadistica objEstadisticas = servicioJuego.estadisticasJugador(mij);
			
				//Consulto nuevamente las respuestas que dio el jugador
				List<TablaJugadorRespuesta> respuestasAnteriores2 = servicioJuego.buscarRespuestasAnteriores(mij);
				
			
				/*Long id_ultimaPregunta =respuestaActual.getPregunta().getId();
				servicioJuego.cambiarEstadoDePregunta(id_ultimaPregunta );
				*/
			 
				
				//Calcular las estadisticas entre los valores de las respuestas que contesto el jugador
				List<Integer> Resultados=servicioJuego.calculoEstadisticas(respuestasAnteriores2,mie);
				
				//Si el jugador ya respondio esa pregunta, no sumar estadisticas
				//Obtengo cada uno de los resultados
				Integer Dinero= Resultados.get(0);
				Integer Estres= Resultados.get(1);
				Integer Social= Resultados.get(2);
				Integer Rendimiento= Resultados.get(3);
				
				//Guardar los resultados en la tabla Estadistica
				servicioJuego.actualizarEstadisticas(Dinero, Estres, Social, Rendimiento, mie);
				
				
				
				
				Integer Gasto =respuestaActual.getGasto(); 
						
				
				//si no tiene suficiente dinero para comprar el resultado de dinero le queda negativo
				if(Dinero <  Gasto)
				{		

					return new ModelAndView("redirect:/DineroInsuficiente");
				}else{
				
				// Si el jugador selecciono la opcion "Inicio", quiere decir que perdio y lo redirigimos al inicio
			
					
					
					//Se resta el costo al dinero que ya teniamos
					Integer saldo= Dinero - Gasto;
					
					//Guardo el saldo de la resta en Estadistica
					servicioJuego.actualizarEstadisticas(saldo, Estres, Social, Rendimiento, mie);
					
			
				/////////////////////////////////////////////
				     
				}
		 }//fin if contestada
		 
		 
		 
	
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
				
				
				Estadistica miEstadistica = servicioJuego.estadisticasJugador( mij);
				
				//Validamos que el jugador pierda el juego
				if((miEstadistica.getEstres() >= 100) || (miEstadistica.getRendimiento() < 20) || (miEstadistica.getRendimiento()<20 && miEstadistica.getSocial()>70)){
					Long UltimaPregunta_id=(long) 0;
					
					//Si supera el 100% de estres pierde el juego por un colapso de estres
					if(miEstadistica.getEstres() >= 100)
							{ 
								UltimaPregunta_id=(long) 400;
							}
					else 
						//Si su rendimiento es menor que 20 pierde el juego
						if(miEstadistica.getRendimiento()<20)
							{
								UltimaPregunta_id=(long) 500;
							}
					
					else 
						//Si su rendimiento es menor que 20 pero su vida social es alta
						//pierde el juego pero es popular
						if( (miEstadistica.getRendimiento()<20 && miEstadistica.getSocial()>70))
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
					
				}else
				{
				
	
				//sino, Paso la lista de opciones a la vista para que siga jugando
				modelo.put("listaR", miRespuesta);
				modelo.put("pregunta", siguientePregunta);
				modelo.put("respuesta", respuesta);
				}
		
//		Estadistica miEstadistica = servicioJuego.estadisticasJugador( mij);
	
			//Paso a la vista los resultados de las estadisticas
				modelo.put("rendimiento", miEstadistica.getRendimiento());
				modelo.put("estres", miEstadistica.getEstres());
				modelo.put("social", miEstadistica.getSocial());
				modelo.put("dinero", miEstadistica.getDinero());
		
					
		
		
	
		return new ModelAndView("juego2",modelo);
	    // }fin else	
	}//fin action
	

	
}
