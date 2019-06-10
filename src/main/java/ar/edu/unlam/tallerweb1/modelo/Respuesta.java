package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String respuesta;
	private Integer rendimiento;
	private Integer estres;
	private Integer social;
	private Integer dinero;
	
	@OneToOne
	private Opcion opcion;
	
	@ManyToMany(mappedBy = "respuestas")
	private List<Jugador> jugadores = new ArrayList<>();
	
	@ManyToOne
	private Ruta ruta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Opcion getOpcion() {
		return opcion;
	}
	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
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
}

