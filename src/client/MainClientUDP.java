package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MainClientUDP {
	public static void main(String[] args) {
		try {
			Socket s=new Socket(InetAddress.getLocalHost(),3500);
			BufferedReader in =new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			BufferedReader inClient=new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("entrez votre commande svp");
				String msg =inClient.readLine();
				out.println(msg);
				String s1= in.readLine();
				System.out.println(s1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
