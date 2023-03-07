package Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import control.Card;
import control.ConnectToTerminal;
import control.IllegalCardExeption;
import control.NumberOfTryExceeded_Exeption;
import control.Validator;

class ConnectToTerminalTest {
	
	private ConnectToTerminal connectToTerminal;
	
	@BeforeEach
	public void setUp() {
		connectToTerminal = new ConnectToTerminal();
	}

	@Test
	@DisplayName("Valid card number should connect successfully")
	public void testValidateCardNumberWithValidCard() throws IllegalCardExeption, NamingException {
		assertTrue(connectToTerminal.validateCardNumber(111));
	}
	
	@Test
	@DisplayName("Invalid card number should throw exception")
	public void testValidateCardNumberWithInvalidCard()  {
		assertThrows(IllegalCardExeption.class, () -> {
			connectToTerminal.validateCardNumber(111111111);
		});
	}
	
	@Test
	@DisplayName("Authenticate with correct code should succeed")
	public void testAuthenticateCodeWithCorrectCode() throws NumberOfTryExceeded_Exeption, IllegalCardExeption, NamingException {
		connectToTerminal.validateCardNumber(111);
		assertTrue(connectToTerminal.authenticateCode(111));
	}
	
	@Test
	@DisplayName("Authenticate with incorrect code should increment number of tries")
	public void testAuthenticateCodeWithIncorrectCode() throws IllegalCardExeption, NamingException, NumberOfTryExceeded_Exeption {
		connectToTerminal.validateCardNumber(111);
		assertFalse(connectToTerminal.authenticateCode(5678));
		assertEquals(1, connectToTerminal.getConnectedCard().getnbrEssaie());
	}
	
	
	@Test
	@DisplayName("Authenticate with incorrect code 4 times should throw exception")
	public void testAuthenticateCodeWithIncorrectCode4Times() throws IllegalCardExeption, NamingException, NumberOfTryExceeded_Exeption {
		ConnectToTerminal a = new ConnectToTerminal();

		a.validateCardNumber(111);
		assertFalse(a.authenticateCode(5678));
		assertFalse(a.authenticateCode(5678));
		assertFalse(a.authenticateCode(5678));
		assertFalse(a.authenticateCode(5678));

		assertThrows(NumberOfTryExceeded_Exeption.class, () -> {
			a.authenticateCode(5678);
		});
	}
	@Test
	@DisplayName("Authenticate with incorrect code 4 times should throw exception")
	public void testToString() throws IllegalCardExeption, NamingException {
		Validator a = new Validator();
		Card c=a.validateCard(111);
	}

	
	
}