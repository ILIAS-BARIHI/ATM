package control;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.sql.DataSource;

public class ATM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ATM() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ConnectToTerminal a = new ConnectToTerminal();

		int NumCarte = Integer.parseInt(request.getParameter("numCarte"));
		int password = Integer.parseInt(request.getParameter("number"));
		System.out.print(NumCarte);
		try {
			boolean c = a.validateCardNumber(NumCarte);
			if (c == true) {
				System.out.print("num carte valide!");
				String texte = "num carte valide!";
				request.setAttribute("text1", texte);
			} else {
				String texte = " carte nom valide!";
				request.setAttribute("text1", texte);
			}
		} catch (IllegalCardExeption e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			boolean c = a.authenticateCode(password);
			if (c == true) {
				String texte = "mot de passe valide!";
				System.out.print("mot de passe valide!");

				request.setAttribute("text2", texte);
			} else {

				String texte = "num carte nom valide!";
				request.setAttribute("text2", texte);

			}
		} catch (NumberOfTryExceeded_Exeption e) {
			e.printStackTrace();
		}
		;
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
