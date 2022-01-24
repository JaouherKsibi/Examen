package model;

public class Employe {
	private int id ;
	private String nom;
	private String login;
	private String password;
	public Employe() {
		// TODO Auto-generated constructor stub
	}
	public Employe(int id, String nom, String login, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", login=" + login + ", password=" + password + "]";
	}
	
	
}
