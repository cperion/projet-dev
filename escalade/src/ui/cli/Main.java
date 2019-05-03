package ui.cli;

import java.util.Scanner;
import ui.cli.Connexion;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // On instancie un objet Scanner associe a l’entree standard
		Connexion conn = new Connexion("lucdas1", "lka1998");
		boolean connexionStatus = false;
		
		System.out.println("Votre username ?");
		String username = sc.nextLine();
		System.out.println("Votre password ?");
		String password = sc.nextLine();
		if(conn.verification(username,password)) {
			System.out.println("Connexion réussie !");
			connexionStatus = true;
		}
		else {
			System.out.println("username ou password erroné !");
		}
		
		if(connexionStatus) {
			System.out.println("Bienvenue dans le menu !" + "\n" +
		"Si vous souhaitez accéder à votre profil, appuyez sur 0,"
		+ " 1 pour la recherche de voies, 2 pour rechercher un profil.");
		int choice = sc.nextInt();
		
		
		}
	}
}