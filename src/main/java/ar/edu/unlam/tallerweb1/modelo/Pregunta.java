package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pregunta {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	@Column( name="textoDeLaPregunta", length=650)
	private String textoDeLaPregunta;

	


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
	
	

	
}
