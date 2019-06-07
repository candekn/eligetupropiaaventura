package ar.edu.unlam.tallerweb1.modelo;
import java.util.ArrayList;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Ruta {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	private String texto;
	@OneToMany
	@Cascade (value= CascadeType.ALL)
	private ArrayList<Opcion> opciones;
	@OneToMany
	private ArrayList<Respuesta> respuestas;
	
	
	
	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
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
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
