package Exercici_12_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

	private static final String urlBaseDades = "jdbc:mysql://localhost:3306/provaJava";
	private static final String usuari = "root";
	private static final String password = "";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(urlBaseDades, usuari, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select codi, titol, genere, director, any, actor1, actor2, actor3 from pelicules");

			while(rs.next()) 
				System.out.println(
						rs.getString("codi") + " " + 
								rs.getString("titol") + " | " + 
								rs.getString("genere") + " | " +
								rs.getString("director") + " | " +
								rs.getString("any") + " | " +
								rs.getString("actor1") + " | " + 
								rs.getString("actor2") + " | " + 
								rs.getString("actor3"));
			con.close();

		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
