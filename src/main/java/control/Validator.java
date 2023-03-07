package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;


public class Validator {

	private Connection connection;



	public Validator() {}
	
	public Card validateCard(int numero) throws IllegalCardExeption, NamingException {
		try {
		/*	// Connect to the database on server pour raliser TEST faire 2 eme methode de connection 
			  Context context = new InitialContext();

			  DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/rh");
			connection = dataSource.getConnection();
*/
			// Connect to the database
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gab",  "root", "");
			// Prepare the SQL statement
			String sql = "SELECT * FROM card ";
			PreparedStatement statement = connection.prepareStatement(sql);

			// Execute the SQL statement and get the result set
			ResultSet resultSet = statement.executeQuery();

			// Check if the card exists in the database
			while (resultSet.next()) {
				if (resultSet.getInt("NumCarte") == numero) {
					Card c = new Card(resultSet.getInt("NumCarte"), resultSet.getInt("psw"),
							resultSet.getBoolean("connexion"), resultSet.getInt("nbrEssaie"),
							resultSet.getBoolean("valide"),resultSet.getString("Nom_Prenom"),
							resultSet.getInt("sommeArgent"));
					return c;
				}
			}

		} catch (SQLException e) {
			System.out.println("Error connecting to the database: " + e.getMessage());
		} 
		throw new IllegalCardExeption();
	}



}