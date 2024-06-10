package Exercici_12_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorBD {

	private static final String urlBaseDades = "jdbc:mysql://localhost:3306/institut";
	private static final String usuari = "root";
	private static final String contrasenya = "";

	// Mètode per crear un alumne.
	protected void crearAlumne(String dni_alumne, String nom_alumne, String edat_alumne, ButtonGroup buttonGroupAlumne) {
		String dni = dni_alumne;
		String nom = nom_alumne;
		String edatStr = edat_alumne;
		int edat = Integer.parseInt(edatStr);

		String nivell = null;
		for (Enumeration<AbstractButton> buttons = buttonGroupAlumne.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				nivell = button.getText();
			}
		}

		String sql = "INSERT INTO alumne (dni, nom, edat, nivell) VALUES (?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, dni);
			pstmt.setString(2, nom);
			pstmt.setInt(3, edat);
			pstmt.setString(4, nivell);

			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Alumne creat correctament!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en crear alumne: " + e.getMessage());
		}
	}

	// Mètode per crear un professor.
	protected void crearProfessor(String dni_professor, String nom_professor, String edat_professor, ButtonGroup buttonGroupProfessor) {
		String dni = dni_professor;
		String nom = nom_professor;
		String edatStr = edat_professor;
		int edat = Integer.parseInt(edatStr);

		String assignatura = null;
		for (Enumeration<AbstractButton> buttons = buttonGroupProfessor.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				assignatura = button.getText();
			}
		}

		String sql = "INSERT INTO professor (dni, nom, edat, assignatura) VALUES (?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, dni);
			pstmt.setString(2, nom);
			pstmt.setInt(3, edat);
			pstmt.setString(4, assignatura);

			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Professor creat correctament!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en crear professor: " + e.getMessage());
		}
	}

	// Mètode per actualitzar la taula de persones.
	protected void actualitzarTaulaPersones(JTable taula) {
		// Consulta SQL per obtenir les dades de les taules 'alumne' i 'professor'.
		String sql = "SELECT dni, nom, edat, 'Alumne' AS tipus FROM alumne "
				+ "UNION "
				+ "SELECT dni, nom, edat, 'Professor' AS tipus FROM professor";

		try (Connection conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			// Netejar la taula abans d'actualitzar-la.
			DefaultTableModel model = (DefaultTableModel) taula.getModel();
			model.setRowCount(0);

			// Afegir les dades recuperades de la base de dades a la taula.
			while (rs.next()) {
				Object[] rowData = {
						rs.getString("dni"),
						rs.getString("nom"),
						rs.getInt("edat"),
						rs.getString("tipus")
				};
				model.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en actualitzar la taula de persones: " + e.getMessage());
		}
	}

	// Mètode per actualitzar la taula d'alumnes.
	protected void actualitzarTaulaAlumnes(JTable taula) {
		// Consulta SQL per obtenir les dades de la taula 'alumne'.
		String sql = "SELECT dni, nom, edat, nivell FROM alumne";

		try (Connection conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			// Netejar la taula abans d'actualitzar-la.
			DefaultTableModel model = (DefaultTableModel) taula.getModel();
			model.setRowCount(0);

			// Afegir les dades recuperades de la base de dades a la taula.
			while (rs.next()) {
				Object[] rowData = {
						rs.getString("dni"),
						rs.getString("nom"),
						rs.getInt("edat"),
						rs.getString("nivell")
				};
				model.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en actualitzar la taula d'alumnes: " + e.getMessage());
		}
	}

	// Mètode per actualitzar la taula de professors.
	protected void actualitzarTaulaProfessors(JTable taula) {
		// Consulta SQL per obtenir les dades de la taula 'professor'.
		String sql = "SELECT dni, nom, edat, assignatura FROM professor";

		try (Connection conn = DriverManager.getConnection(urlBaseDades, usuari, contrasenya);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			// Netejar la taula abans d'actualitzar-la.
			DefaultTableModel model = (DefaultTableModel) taula.getModel();
			model.setRowCount(0);

			// Afegir les dades recuperades de la base de dades a la taula.
			while (rs.next()) {
				Object[] rowData = {
						rs.getString("dni"),
						rs.getString("nom"),
						rs.getInt("edat"),
						rs.getString("assignatura")
				};
				model.addRow(rowData);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en actualitzar la taula de professors: " + e.getMessage());
		}
	}

}
