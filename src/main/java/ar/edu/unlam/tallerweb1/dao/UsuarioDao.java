package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Jugador;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Jugador consultarJugador(Jugador usuario);
	void guardarJugador(Jugador usuario);
}
