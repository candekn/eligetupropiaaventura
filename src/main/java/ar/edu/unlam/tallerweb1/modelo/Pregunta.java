package ar.edu.unlam.tallerweb1.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pregunta {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	@Column( name="textoDeLaPregunta", length=650)
	private String textoDeLaPregunta;


	private String estado;


		@ManyToMany()
	  @JoinTable(name="TablaPreguntaPersonaje", 
	  joinColumns={@JoinColumn(name="IdPregunta")}, 
	  inverseJoinColumns={@JoinColumn(name="IdImagenPersonaje")})
		    private List<ImagenPersonaje> personajes;

	
	

	
	@ManyToOne
	private ImagenFondo imagenfondo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTextoDeLaPregunta() {
		return textoDeLaPregunta;
	}
	public void setTextoDeLaPregunta(String textoDeLaPregunta) {
		this.textoDeLaPregunta = textoDeLaPregunta;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public ImagenFondo getImagenfondo() {
		return imagenfondo;
	}
	public void setImagenfondo(ImagenFondo imagenfondo) {
		this.imagenfondo = imagenfondo;
	}
	public List<ImagenPersonaje> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<ImagenPersonaje> personajes) {
		this.personajes = personajes;
	}

}
