package ar.edu.unlam.tallerweb1.modelo;
import java.util.ArrayList;
import java.util.List;

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
	private String opcion1;
	private String opcion2;
	private String opcion3;
	
	
	@OneToMany
	private List<Opcion> opciones;
	@OneToMany
	private List<Respuesta> respuestas;
	
	
	
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
	public List<Opcion> getOpciones() {
		return opciones;
	}
	public void setOpciones(List<Opcion> opciones) {
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
	public String getOpcion1() {
		return opcion1;
	}
	public void setOpcion1(String opcion1) {
		this.opcion1 = opcion1;
	}
	public String getOpcion2() {
		return opcion2;
	}
	public void setOpcion2(String opcion2) {
		this.opcion2 = opcion2;
	}
	public String getOpcion3() {
		return opcion3;
	}
	public void setOpcion3(String opcion3) {
		this.opcion3 = opcion3;
	}
	
}
