package modelo;

import java.io.Serializable;

public class ConfiguracionUsuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Atributos.
	private String resolucion;
	private String modoPantalla;
	private float volumenMusica;
	private float volumenEfectos;
	
	// Constructor vacío.
	public ConfiguracionUsuario() {}

	// Getters y setters.
	public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getModoPantalla() {
        return modoPantalla;
    }

    public void setModoPantalla(String modoPantalla) {
        this.modoPantalla = modoPantalla;
    }

    public float getVolumenMusica() {
        return volumenMusica;
    }

    public void setVolumenMusica(float volumenMusica) {
        this.volumenMusica = volumenMusica;
    }

    public float getVolumenEfectos() {
        return volumenEfectos;
    }

    public void setVolumenEfectos(float volumenEfectos) {
        this.volumenEfectos = volumenEfectos;
    }

}
