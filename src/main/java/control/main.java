package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class main {

	public static void main(String[] args) throws IllegalCardExeption, NumberOfTryExceeded_Exeption, NamingException  {

ConnectToTerminal a = new ConnectToTerminal();
 a.validateCardNumber(111);
 a.authenticateCode(141);
 a.authenticateCode(141);
 a.authenticateCode(141);
 a.authenticateCode(111);
System.out.print(a);
	}

}