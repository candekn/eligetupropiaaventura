package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rta;
	@OneToMany
	@Cascade (value= CascadeType.ALL)
	private ArrayList<Opcion> opciones;
	 @ManyToMany(mappedBy = "respuestas")
	    private ArrayList<Jugador> jugadores;
	@ManyToOne
	private Ruta ruta;
	 
	 
	 public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public ArrayList<Opcion> getOpciones() {
		return opciones;
	}
	public void setOpciones(ArrayList<Opcion> opciones) {
		this.opciones = opciones;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRta() {
		return rta;
	}
	public void setRta(String rta) {
		this.rta = rta;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	 
	 
}
