package Examen_7_8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Torn {

	private Persona persona;
	private boolean atencioCorrecta;
	private LocalDate data;
	private LocalTime hora;
	
	private static DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static DateTimeFormatter horaFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private static int numTorn = 1;
	private int torn;
	
	public Torn(Persona persona, boolean atencioCorrecta) {
		this.persona = persona;
		this.atencioCorrecta = atencioCorrecta ? true : false;
		this.data = LocalDate.now();
		this.hora = LocalTime.now();
		this.torn = numTorn + 1;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isAtencioCorrecta() {
		return atencioCorrecta;
	}

	public void setAtencioCorrecta(boolean atencioCorrecta) {
		this.atencioCorrecta = atencioCorrecta;
	}
	
	public LocalDate getData() {
		return data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public int getTorn() {
		return torn;
	}
	
	@Override
	public String toString() {
		StringBuffer torn = new StringBuffer();
		
		torn.append(IU.llista('D', 
				"DNI: " + persona.getDni(),
				"Nom: " + persona.getNom(),
				"Edat: " + persona.getEdat(),
				"Data: " + dataFormat.format(data),
				"Hora: " + horaFormat.format(hora),
				"Atenció correcta: " + (atencioCorrecta ? "Si" : "No")));
		
		return torn.toString();
	}
}
