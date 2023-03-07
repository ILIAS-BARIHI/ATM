package Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.Card;
import control.IllegalCardExeption;
import control.Validator;

public class ValidatorTest {

    private static final int EXISTING_CARD_NUMBER = 123456;
    private static final int NON_EXISTING_CARD_NUMBER = 999999;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/gab";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private Connection connection;

    @Before
    public void setUp() throws Exception {
        // Create a connection to the database
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        // Insert a test card into the database
        PreparedStatement insertStatement = connection.prepareStatement(
                "INSERT INTO card (NumCarte, psw, connexion, nbrEssaie, valide, Nom_Prenom,sommeArgent) " +
                        "VALUES (?, ?, ?, ?, ?, ?,?)");
        insertStatement.setInt(1, EXISTING_CARD_NUMBER);
        insertStatement.setInt(2, 1234);
        insertStatement.setBoolean(3, false);
        insertStatement.setInt(4, 0);
        insertStatement.setBoolean(5, true);
        insertStatement.setString(6, "John Doe");
        insertStatement.setInt(7, 100);
        insertStatement.executeUpdate();
    }

    @After
    public void tearDown() throws Exception {
        // Delete the test card from the database
        PreparedStatement deleteStatement = connection.prepareStatement(
                "DELETE FROM card WHERE NumCarte = ?");
        deleteStatement.setInt(1, EXISTING_CARD_NUMBER);
        deleteStatement.executeUpdate();

        // Close the database connection
        connection.close();
    }

    @Test
    public void testValidateCardWithExistingCard() throws IllegalCardExeption, NamingException {
        Validator validator = new Validator();

        Card card = validator.validateCard(EXISTING_CARD_NUMBER);
System.out.print(card.getnmbr());
        assertNotNull(card);
        assertEquals(EXISTING_CARD_NUMBER, card.getnmbr());
        assertEquals(1234, card.getpswd());
        assertFalse(card.isConnected());
        assertEquals(0, card.getnbrEssaie());
        assertTrue(card.isValid());
        assertEquals(100, card.getsommeArgent());

        assertEquals("John Doe", card.getNom());
    }

    @Test
    public void testValidateCardWithNonExistingCard() throws IllegalCardExeption, NamingException {
        Validator validator = new Validator();

        assertThrows(IllegalCardExeption.class, () -> validator.validateCard(NON_EXISTING_CARD_NUMBER));

        
    }

}