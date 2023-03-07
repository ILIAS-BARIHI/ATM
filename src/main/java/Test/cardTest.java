package Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Card;
import control.IllegalCardExeption;
import control.SoldeInsuffisantException;

class cardTest {

	
	@Test
	public void testIsValid() {
		Card card1 = new Card(1234, 5678, true, 3, true, "Nom1",100);
		Card card2 = new Card(5678, 1234, false, 5, false, "Nom2",100);

		assertTrue(card1.isValid()); // Test avec une carte valide
		assertFalse(card2.isValid()); // Test avec une carte invalide
	}
	 @Test
	    public void testIsConnected() {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        assertTrue(card.isConnected());
	        card.setConnection(false);
	        assertFalse(card.isConnected());
	    }
	    

	    
	    @Test
	    public void testGetnmbr() {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        assertEquals(1234, card.getnmbr());
	        card.setnmbr(5678);
	        assertEquals(5678, card.getnmbr());
	    }
	    
	    @Test
	    public void testGetNom() {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        assertEquals("John", card.getNom());
	    }
	    
	    @Test
	    public void testGetnbrEssaie() {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        assertEquals(0, card.getnbrEssaie());
	        card.addnbrEssaie();
	        assertEquals(1, card.getnbrEssaie());
	    }
	    
	    @Test
	    public void testSetValidation() {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        assertFalse(card.isValid());
	        card.setValidation(true);
	        assertTrue(card.isValid());
	        card.setValidation(false);
	        assertFalse(card.isValid());
	    }
	    
	    @Test
	    public void testCheckSecretCode() {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        assertTrue(card.checkSecretCode(4321));
	        assertFalse(card.checkSecretCode(1234));
	    }
	    @Test
	    public void testAddSOLDE() {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        card.addargent(50);
	        assertEquals(150, card.getsommeArgent());

	    }
	    @Test
	    public void retireArgent_avec_solde () throws SoldeInsuffisantException {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        card.addargent(50);
	        card.retireargent(75);
	        assertEquals(75, card.getsommeArgent());

	    }
	    @Test
	    public void retireArgent_sans_solde () throws SoldeInsuffisantException {
	        Card card = new Card(1234, 4321, true, 0, false, "John",100);
	        card.addargent(50);
	        
	        assertThrows(SoldeInsuffisantException.class, () -> card.retireargent(200));

	    }
	}

