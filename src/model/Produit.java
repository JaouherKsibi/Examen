package model;

public class Produit {
	private int id;
	private String description;
	public Produit() {
		// TODO Auto-generated constructor stub
	}
	public Produit(int id, String description) {
		super();
		this.id = id;
		this.description = description;
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
	@Override
	public String toString() {
		return "Produit [id=" + id + ", description=" + description + "]";
	}
	

}
