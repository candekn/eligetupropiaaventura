package ar.edu.unlam.tallerweb1.modelo;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


@Entity

public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer rendimiento;
	private Integer estres;
	private Integer social;
	private Integer dinero;
	private Integer puntaje;
	private Long ultimaRespuesta;
	
	@OneToOne
	private Usuario usuario;
	  
	@ManyToMany()
	  @JoinTable(name="JugadorRespuesta", 
	  joinColumns={@JoinColumn(name="IdJugador")}, 
	  inverseJoinColumns={@JoinColumn(name="IdRespuesta")})
		    private List<Respuesta> respuestas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Long getUltimaRespuesta() {
		return ultimaRespuesta;
	}

	public void setUltimaRespuesta(Long ultimaRespuesta) {
		this.ultimaRespuesta = ultimaRespuesta;
	}
  	  
}
