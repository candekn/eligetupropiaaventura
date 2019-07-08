package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Estadistica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer rendimiento;
	private Integer estres;
	private Integer social;
	private Integer dinero;
	
	@OneToOne
	private Jugador jugador;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	
	
	
}
