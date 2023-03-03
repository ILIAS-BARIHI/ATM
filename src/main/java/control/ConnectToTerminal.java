package control;

public class ConnectToTerminal {
	private Card connectedCard;

	public boolean validateCardNumber(int number) throws IllegalCardExeption {
		Validator validator = new Validator();
		if (validator.validateCard1(number) != null) {
			this.connectedCard = validator.validateCard1(number);
			return true;
		} else {
			throw new IllegalCardExeption();
		}
	}

	public void authenticateCode(int secretCode) throws NumberOfTryExceeded_Exeption {
		if (connectedCard.checkSecretCode(secretCode)) {
			System.out.print("vous etes connecte  " + connectedCard.getNom() + "\n");
		} 
		else {
			if (connectedCard.getnbrEssaie() < 4) {
				connectedCard.addnbrEssaie();
				System.out.print("mot de passe errone \n");
			}
			else 
				throw new NumberOfTryExceeded_Exeption();
		}
		

	}

	@Override
	public String toString() {
		return connectedCard.toString();
	}

}
