package control;

public class main {

	public static void main(String[] args) throws IllegalCardExeption, NumberOfTryExceeded_Exeption  {

ConnectToTerminal a = new ConnectToTerminal();
 a.validateCardNumber(111);
 a.authenticateCode(141);
 a.authenticateCode(141);
 a.authenticateCode(141);
 a.authenticateCode(111);
System.out.print(a);
	}

}
