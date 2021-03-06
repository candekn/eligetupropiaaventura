package ar.edu.unlam.tallerweb1.modelo;



import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class Partida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	private List<TablaJugadorPartida> tablajugadorpartida;
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<TablaJugadorPartida> getTablajugadorpartida() {
		return tablajugadorpartida;
	}


	public void setTablajugadorpartida(List<TablaJugadorPartida> tablajugadorpartida) {
		this.tablajugadorpartida = tablajugadorpartida;
	}


	



	
	


}
