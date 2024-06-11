package ExamenProjecte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorBD {
	// Dades de connexió a la base de dades MySQL.
	private static final String URL = "jdbc:mysql://localhost:3306/agenda_personal";
	private static final String USUARI = "root";
	private static final String CONTRASENYA = "";

	// Mètode per crear un alumne.
	protected void crearContacte(String nom, String telefon, String email) {
		String sql = "INSERT INTO contactes (nom, telefon, email) VALUES (?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nom);
			pstmt.setInt(2, Integer.parseInt(telefon));
			pstmt.setString(3, email);

			pstmt.executeUpdate();
			Missatge.exit(null, "Contacte creat correctament!");

		} catch (SQLException e) {
			Missatge.error(null, "Error en crear contacte: " + e.getMessage());
		}
	}

	// Mètode per eliminar un contacte.
	public void eliminarContacte(int id) {
		String sql = "DELETE FROM contactes WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			Missatge.exit(null, "Contacte eliminat correctament!");

		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				// Excepció llançada quan hi ha una restricció d'integritat SQL (foreign key).
				// Passa quan s'intenta eliminar un contacte que està vinculat amb la seva id a una cita per una FK.
				Missatge.error(null, "No es pot eliminar el contacte mentre estigui vinculat a una cita existent.");

			} else {
				Missatge.error(null, "Error en eliminar contacte: " + e.getMessage());
			}
		}
	}

	// Mètode per actualitzar la taula de contactes.
	protected void actualitzarTaulaContactes(JTable taula) {
		String sql = "SELECT id, nom, telefon, email FROM contactes";

		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			// Netejar la taula abans d'actualitzar-la.
			DefaultTableModel model = (DefaultTableModel) taula.getModel();
			model.setRowCount(0);

			// Afegir les dades recuperades de la base de dades a la taula.
			while (rs.next()) {
				Object[] rowData = {
						rs.getInt("id"),
						rs.getString("nom"),
						rs.getInt("telefon"),
						rs.getString("email")
				};
				model.addRow(rowData);
			}
		} catch (SQLException e) {
			Missatge.error(null, "Error en actualitzar la taula de contactes: " + e.getMessage());
		}
	}

	// Mètode per obtenir la llista de contactes existents des de la base de dades.
	public List<String> obtenirContactes() {
		List<String> llistaContactes = new ArrayList<>();
		String sql = "SELECT nom FROM contactes";
		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				llistaContactes.add(rs.getString("nom"));
			}
		} catch (SQLException e) {
			Missatge.error(null, "Error en obtenir la llista de contactes: " + e.getMessage());
		}

		return llistaContactes;
	}

	// Mètode per crear una cita.
	protected void crearCita(String data, String hora, String descripcio, int id_contacte) {
		String sql = "INSERT INTO cites (data, hora, descripcio, id_contacte) VALUES (?, ?, ?, ?)";
		try(Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, data);
			pstmt.setString(2, hora);
			pstmt.setString(3, descripcio);
			pstmt.setInt(4, id_contacte);

			pstmt.executeUpdate();
			Missatge.exit(null, "Cita creada correctament!");

		} catch (SQLException e) {
			Missatge.error(null, "Error en crear cita: " + e.getMessage());
		}
	}

	// Mètode per eliminar una cita.
	public void eliminarCita(int id) {
		String sql = "DELETE FROM cites WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			Missatge.exit(null, "Cita eliminada correctament!");

		} catch (SQLException e) {
			Missatge.error(null, "Error en eliminar cita: " + e.getMessage());
		}
	}

	// Mètode per actualitzar la taula de cites.
	protected void actualitzarTaulaCites(JTable taula) {
		String sql = "SELECT id, DATE_FORMAT(data, '%d-%m-%Y') AS data, hora, descripcio, id_contacte FROM cites";

		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			DefaultTableModel model = (DefaultTableModel) taula.getModel();
			model.setRowCount(0);

			while (rs.next()) {
				Object[] rowData = {
						rs.getInt("id"),
						rs.getString("data"),
						rs.getString("hora"),
						rs.getString("descripcio"),
						rs.getInt("id_contacte")
				};
				model.addRow(rowData);
			}
		} catch (SQLException e) {
			Missatge.error(null, "Error en actualitzar la taula de cites: " + e.getMessage());
		}
	}

	// Mètode per obtenir el nom del contacte a partir de la seva id_contacte.
	public String obtenirNomContacte(int idContacte) {
		String nomContacte = null;
		String sql = "SELECT nom FROM contactes WHERE id = ?";
		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, idContacte);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				nomContacte = rs.getString("nom");
			}
		} catch (SQLException e) {
			Missatge.error(null, "Error en obtenir el nom del contacte: " + e.getMessage());
		}
		return nomContacte;
	}

	public ArrayList<String> obtenirNomsContactes() {
		ArrayList<String> nomsContactes = new ArrayList<>();

		String sql = "SELECT nom FROM contactes";

		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				String nom = rs.getString("nom");
				nomsContactes.add(nom);
			}
		} catch (SQLException e) {
			Missatge.error(null, "Error en obtenir els noms de contactes: " + e.getMessage());
		}

		return nomsContactes;
	}

	// Mètode per obtenir la Id d'un contacte.
	public int obtenirIdContacte(String nomContacte) {
		String sql = "SELECT id FROM contactes WHERE nom = ?";
		int idContacte = -1; // Valor per defecte si no es troba cap contacte amb aquest nom.

		try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, nomContacte);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				idContacte = rs.getInt("id");
			}

		} catch (SQLException e) {
			Missatge.error(null, "Error en obtenir la id del contacte: " + e.getMessage());
		}

		return idContacte;
	}


}

