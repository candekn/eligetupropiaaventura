package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


@Entity

public class Consigna {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	  
		@ManyToMany()
		  @JoinTable(name="ConsignaOpcion", 
		  joinColumns={@JoinColumn(name="IdConsigna")}, 
		  inverseJoinColumns={@JoinColumn(name="IdOpcion")})
			    private List<Opcion> opciones;

		
		@ManyToOne
		private Materia materia;
		
		

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


		public List<Opcion> getOpciones() {
			return opciones;
		}


		public void setOpciones(List<Opcion> opciones) {
			this.opciones = opciones;
		}


		public Materia getMateria() {
			return materia;
		}


		public void setMateria(Materia materia) {
			this.materia = materia;
		}
	
	
	
	
	
}
