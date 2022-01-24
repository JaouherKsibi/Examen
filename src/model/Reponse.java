package model;

public class Reponse {
	private int id;
	private String description;
	private Employe employe;
	
	public Reponse() {
		// TODO Auto-generated constructor stub
	}

	public Reponse(int id, String description, Employe employe) {
		this.id = id;
		this.description = description;
		this.employe = employe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	@Override
	public String toString() {
		return "Reponse [id=" + id + ", description=" + description + ", employe=" + employe + "]";
	}
	
	

}
