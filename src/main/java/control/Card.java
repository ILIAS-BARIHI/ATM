package control;

public class Card {

	private int NumCarte;
	private int psw;
	private boolean connexion;
	private int nbrEssaie;
	private boolean valide;
	private String Nom;

	public Card(int a, int b, boolean c, int n, boolean v,String s) {
		this.NumCarte = a;
		this.psw = b;
		this.valide = v;
		this.nbrEssaie = n;
		this.connexion = c;
		this.Nom =s;
	}

	public boolean isConnected() {
		if (this.connexion == true)
			return true;
		else
			return false;
	}

	public void setConnection(boolean v) {
		this.connexion = v;
	}

	public boolean isValid() {
		if (this.nbrEssaie <= 4) {
			this.valide = true;
			nbrEssaie++;
			return true;
		} else {
			this.valide = false;
			return false;
		}
	}



	public int getnmbr() {
		return this.NumCarte;
	}
	public String getNom() {
		return this.Nom;
	}
	public int getnbrEssaie() {
		return this.nbrEssaie;
	}

	public void setnmbr(int num) {
		this.NumCarte = num;
	}
	public void addnbrEssaie( ) {
		this.nbrEssaie ++ ;
	}
	
	public void setValidation(boolean v) {
		this.valide = v;
	}
	
	public boolean checkSecretCode(int code) {
		if (this.psw == code)
			return true;
		else
			return false;

	}
}
