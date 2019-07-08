package ar.edu.unlam.tallerweb1.modelo;
import java.util.ArrayList;
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
public class ImagenFondo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreImgFondo;



//	@ManyToMany()
//	  @JoinTable(name="TablaFondoPersonaje", 
//	  joinColumns={@JoinColumn(name="IdImagenFondo")}, 
//	  inverseJoinColumns={@JoinColumn(name="IdImagenPersonaje")})
//		    private List<ImagenPersonaje> personajes;
	
	@OneToMany
	private List<Pregunta> pregunta;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreImgFondo() {
		return nombreImgFondo;
	}

	public void setNombreImgFondo(String nombreImgFondo) {
		this.nombreImgFondo = nombreImgFondo;
	}

	
	

	public List<Pregunta> getPregunta() {
		return pregunta;
	}

	public void setPregunta(List<Pregunta> pregunta) {
		this.pregunta = pregunta;
	}

	

	
	
}
