package control;

public class Card {

	private int NumCarte;
	private int psw;
	private boolean connexion;
	private int nbrEssaie;
	private boolean valide;
	private String Nom;
	private int sommeArgent;

	public Card(int a, int b, boolean c, int n, boolean v, String s,int o) {
		this.NumCarte = a;
		this.psw = b;
		this.valide = v;
		this.nbrEssaie = n;
		this.connexion = c;
		this.Nom = s;
		this.sommeArgent=o;
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
		return this.valide;
	}

	public int getnmbr() {
		return this.NumCarte;
	}

	public String getNom() {
		return this.Nom;
	}

	public int getsommeArgent() {
		return this.sommeArgent;
	}

	public int getnbrEssaie() {
		return this.nbrEssaie;
	}

	public void setnmbr(int num) {
		this.NumCarte = num;
	}

	public int addargent(int num) {
		this.sommeArgent += num;
		return this.sommeArgent;
	}

	public void retireargent(int num) throws SoldeInsuffisantException {
		if (this.sommeArgent - num < 0) {
			throw new SoldeInsuffisantException();
		} else
			this.sommeArgent -= num;

	}

	public void addnbrEssaie() {
		this.nbrEssaie++;
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

	public int getpswd() {
		// TODO Auto-generated method stub
		return this.psw;
	}
}
