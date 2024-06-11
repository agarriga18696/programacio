package ExamenProjecte;

public class Contacte {
	private String nom;
	private String telefon;
	private String email;

	public Contacte(String nom, String telefon, String email) {
		this.nom = nom;
		this.telefon = telefon;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contacte{" +
				"nom='" + nom + '\'' +
				", telefon='" + telefon + '\'' +
				", email='" + email + '\'' +
				'}';
	}
	
}

