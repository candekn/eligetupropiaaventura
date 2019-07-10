package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


@Entity

public class Materia {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@OneToMany
	private List<Consigna> consigna;
	

	@OneToOne
	private Examen examen;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Consigna> getConsigna() {
		return consigna;
	}


	public void setConsigna(List<Consigna> consigna) {
		this.consigna = consigna;
	}


	public Examen getExamen() {
		return examen;
	}


	public void setExamen(Examen examen) {
		this.examen = examen;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
