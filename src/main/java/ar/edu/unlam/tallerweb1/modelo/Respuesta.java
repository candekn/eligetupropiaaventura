package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String opcion;
	private Integer rendimiento;
	private Integer estres;
	private Integer social;
	private Integer dinero;
	
	@ManyToMany(mappedBy = "respuestas")
	private List<Jugador> jugadores = new ArrayList<>();
	
	@ManyToOne
	private Pregunta pregunta;
	
	@OneToOne
	private Pregunta preguntaSiguiente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public Integer getRendimiento() {
		return rendimiento;
	}

	public void setRendimiento(Integer rendimiento) {
		this.rendimiento = rendimiento;
	}

	public Integer getEstres() {
		return estres;
	}

	public void setEstres(Integer estres) {
		this.estres = estres;
	}

	public Integer getSocial() {
		return social;
	}

	public void setSocial(Integer social) {
		this.social = social;
	}

	public Integer getDinero() {
		return dinero;
	}

	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Pregunta getPreguntaSiguiente() {
		return preguntaSiguiente;
	}

	public void setPreguntaSiguiente(Pregunta preguntaSiguiente) {
		this.preguntaSiguiente = preguntaSiguiente;
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	


}

