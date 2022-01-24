package serveur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import model.Employe;
import model.Produit;
import model.Reclamation;
import model.Reponse;

public class Traitement extends Thread{
	private Socket socket;
	
	public Traitement() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Traitement(Socket socket) {
		this.socket = socket;
	}



	@Override
	public void run() {
		try {
			BufferedReader clientIn =new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			PrintWriter out =new PrintWriter(this.socket.getOutputStream(), true);
			String msgClient= clientIn.readLine();  
			boolean connected=false;
			Employe employeConnecte=null;
			//System.out.println("message recu du client :"+msgClient);
			if (msgClient.startsWith("CONNECT")) {
				String msg[] =msgClient.split("CONNECT ");
				String msg1[]=msg[1].split("&&");
				String login=msg1[0];
				String password=msg1[1];
				for (Employe employe : MainAppServer.listeEmployes) {
					if (employe.getLogin().equals(login) && employe.getPassword().equals(password)) {
						connected=true;
						employeConnecte=employe;
						break;
					}
				}
				if (connected==true) {
					out.println("you are connected ");
					while (true) {
						msgClient= clientIn.readLine();
						if (msgClient.equals("RECLAMS")) {
							String aEnvoyerString="";
							for (Reclamation reclamation : MainAppServer.listeReclamations) {
								aEnvoyerString+=reclamation.toString();
							}
							out.println("la liste des reclamation contient:"+aEnvoyerString);
						}
						else if (msgClient.startsWith("RECLAM ")) {
							String msg3[] =msgClient.split("RECLAM ");
							String nomClient =msg3[1];
							String aEnvoyerString="";
							for (Reclamation reclamation : MainAppServer.listeReclamations) {
								if (reclamation.getNomClient().equals(nomClient)) {
									aEnvoyerString+=reclamation.toString();
								}
							}
							out.println("la liste des reclamation contient:"+aEnvoyerString);
						}
						else if (msgClient.startsWith("ADDREP ")) {
							String msg3[] =msgClient.split("ADDREP ");
							String msg4 =msg3[1];
							String[] msg5=msg4.split("&&");
							int idReclamation=Integer.parseInt(msg5[0]);
							String description=msg5[1];
							boolean existe=false;
							for (Reclamation reclamation : MainAppServer.listeReclamations) {
								if (reclamation.getId()==idReclamation) {
									existe=true;
									List<Reponse> listeReponses= reclamation.getListeReponse();
									listeReponses.add(new Reponse(listeReponses.size()+1,description,employeConnecte));
									reclamation.setListeReponse(listeReponses);
									out.println("reponse ajoutée avec succes ");
									break;
								}
							}
							if (existe==false) {
								out.println("erreur la commande suivante n'existe pas ");
							}
						}
						else if (msgClient.startsWith("NBREREC ")) {
							String [] msg3=msgClient.split("NBREREC ");
							int idProduit=Integer.parseInt(msg3[1]);
							boolean b=false;
							for (Produit produit : MainAppServer.listeProduits) {
								if (produit.getId()==idProduit) {
									b=true;
									int nbr=0;
									for (Reclamation reclamation :MainAppServer.listeReclamations ) {
										if (reclamation.getProduit().getId()==idProduit) {
											nbr++;
										}
									}
									out.println("le nombre de reclamation pour ce produit est egal à :"+nbr);
									
									
									break;
								}
							}
							if (b==false) {
								out.println("Erreur: le produit souhaite est introuvable !");
							}
						}
						else {
							out.println("la commande que vous avez tapé est introuvable");
						}
					}
					
				}else {
					out.println("error:you are not connected ");
					
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
