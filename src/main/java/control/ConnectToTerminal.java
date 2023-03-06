package control;

import javax.naming.NamingException;

public class ConnectToTerminal {
	private Card connectedCard;

	public boolean validateCardNumber(int number) throws IllegalCardExeption, NamingException {
		Validator validator = new Validator();
		if (validator.validateCard(number) != null) {
			this.connectedCard = validator.validateCard(number);
			this.connectedCard.setValidation(true);
			return true;
		} else {
			this.connectedCard.setValidation(false);

			throw new IllegalCardExeption();
		}
	}

	public boolean authenticateCode(int secretCode) throws NumberOfTryExceeded_Exeption {
		if (connectedCard.checkSecretCode(secretCode)) {
			
      return true;		} 
		else {
			if (connectedCard.getnbrEssaie() < 4) {
				connectedCard.addnbrEssaie();
return false;			}
			else 
				throw new NumberOfTryExceeded_Exeption();
		}
		

	}

	@Override
	public String toString() {
		return connectedCard.toString();
	}

}
