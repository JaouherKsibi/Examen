package serveur;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Employe;
import model.Produit;
import model.Reclamation;
import model.Reponse;

public class MainAppServer {
	
	public static List<Employe> listeEmployes;
	public static List<Produit> listeProduits;
	public static List<Reclamation> listeReclamations;
	
	public static void main(String[] args) {
		listeEmployes=new ArrayList<Employe>();
		listeProduits=new ArrayList<Produit>();
		listeReclamations=new ArrayList<Reclamation>();
		listeEmployes.add(new Employe(1, "jaouher", "jaouher", "ksibi"));
		listeEmployes.add(new Employe(2, "jaouher1", "jaouher1", "ksibi1"));
		listeProduits.add(new Produit(1, "Product1"));
		listeProduits.add(new Produit(2, "Product2"));
		listeReclamations.add(new Reclamation(1, "description Reclamation1", "non-confirme","salah" , new Produit(1, "Product1"), new ArrayList<Reponse>()));
		listeReclamations.add(new Reclamation(2, "description Reclamation2", "non-confirme","salah" , new Produit(1, "Product1"), new ArrayList<Reponse>()));
		try {
			
			ServerSocket socket =new ServerSocket(3500);
			while(true) {
				Socket s=socket.accept();
				Traitement t=new Traitement(s);
				t.start();
			}
			
		
		} catch (Exception e) {
		}
		
	}

}
