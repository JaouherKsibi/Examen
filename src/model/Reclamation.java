package model;

import java.util.List;

public class Reclamation {
	private int id;
	private String description;
	private String typeReclamation;
	private String nomClient;
	private Produit produit;
	private List<Reponse> listeReponse;
	
	public Reclamation() {
		// TODO Auto-generated constructor stub
	}

	public Reclamation(int id, String description, String typeReclamation, String nomClient, Produit produit,
			List<Reponse> listeReponse) {
		super();
		this.id = id;
		this.description = description;
		this.typeReclamation = typeReclamation;
		this.nomClient = nomClient;
		this.produit = produit;
		this.listeReponse = listeReponse;
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

	public String getTypeReclamation() {
		return typeReclamation;
	}

	public void setTypeReclamation(String typeReclamation) {
		this.typeReclamation = typeReclamation;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Reponse> getListeReponse() {
		return listeReponse;
	}

	public void setListeReponse(List<Reponse> listeReponse) {
		this.listeReponse = listeReponse;
	}

	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", description=" + description + ", typeReclamation=" + typeReclamation
				+ ", nomClient=" + nomClient + ", produit=" + produit + ", listeReponse=" + listeReponse + "]";
	}
	
	

}
