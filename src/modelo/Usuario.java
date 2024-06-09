package modelo;

import java.io.Serializable;
import java.util.UUID;

public class Usuario implements Serializable {

	// Atributos.
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String nombre;
	private String clave;
	private int partidasGanadas;
	private int partidasPerdidas;

	// Constructor.
	public Usuario(String nombre, String clave) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.clave = clave;
		this.partidasGanadas = 0;
		this.partidasPerdidas = 0;
	}

	// Getters y setters.
	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getPartidasGanadas() {
		return partidasGanadas;
	}

	public void setPartidasGanadas(int partidasGanadas) {
		this.partidasGanadas = partidasGanadas;
	}

	public int getPartidasPerdidas() {
		return partidasPerdidas;
	}

	public void setPartidasPerdidas(int partidasPerdidas) {
		this.partidasPerdidas = partidasPerdidas;
	}

}
