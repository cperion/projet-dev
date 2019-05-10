package ui.cli;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.Io;
import io.Test;
import principal.Grimpeur;
import principal.MainBoard;

public class Mainloop {

	String help = "";

	public static void startconsole(MainBoard mb, int id) {
		System.out.println("Bienvenue dans la console. Tapez help pour avoir la liste des commandes disponibles");
		
		boolean exit=false;
		while (!exit) {
			System.out.println();
			System.out.print(mb.getGrimpeurs().get(id).getPseudo()+ " : " + Integer.toString(id)+ " : "); // Le prompt
			Scanner scan = new Scanner(System.in);
			String line= scan.nextLine();
			Command command = new Command(line);
			command.exec(mb, id);
			if (exit) {
				scan.close();
			}
		}
		
	}
	public static  void startadminconsole(MainBoard mb) {
		int id=0;
		System.out.println("Bienvenue dans la console administrateur. Tapez help pour avoir la liste des commandes disponibles");
		boolean exit=false;
		while (!exit) {
			System.out.println();
			System.out.print(mb.getGrimpeurs().get(id).getPseudo()+ " : " + Integer.toString(id)+ " : "); // Le prompt
			Scanner scan = new Scanner(System.in);
			String line= scan.nextLine();
			Command command = new Command(line);
			command.exec(mb, id);
			if (exit) {
				scan.close();
			}
		}
	}

	public static void start(MainBoard mb, int id) {
		if (id == 0) {
			System.out.println("God mode");
			startconsole(mb, 0);
		} else startconsole(mb, id);

	}

	public static void login(MainBoard mb) {
		byte[] hash = "".getBytes();
		byte[] hash2 = "".getBytes();
		int id=0;
		boolean go = false;
			System.out.println("Entrez votre id");
			Scanner scan = new Scanner(System.in);
			id = scan.nextInt();
			System.out.println("Entrez votre mot de passe");
			scan.nextLine();
			String mdp = scan.nextLine();
			System.out.println(mdp);
			try { MessageDigest mdigest = MessageDigest.getInstance("SHA-256");
				hash = mdigest.digest(mdp.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(hash);
			hash2=mb.getHashlist().get(id);
			boolean pass = Arrays.equals(hash, hash2);
			scan.close();
		
		if (pass) {start(mb, id);}
		
	}
	public static void mbload(String fname) {
		MainBoard mb = Io.loadMainBoard(fname);

	}
	public static void mbselect() {
		System.out.println("Entrez le nom du fichier de sauvegarde à charger :");
		Scanner scan = new Scanner(System.in);
		String fname = new String();
		fname = scan.nextLine();
		scan.close();
		if (!fname.endsWith(".mb")) {
			fname += ".mb";
		}
		mbload(fname);
	}

	public static void createmb() {
		MainBoard mb = new MainBoard();
		System.out.println("Entrez le pseudo admin");
		Scanner scan = new Scanner(System.in);
		String pseudo = scan.nextLine();
		System.out.println("Entrez votre age :");
		int age = scan.nextInt();
		System.out.println("Entrez votre niveau :");
		int niveau = scan.nextInt();
		Grimpeur g = new Grimpeur(0, pseudo, age, niveau );
		mb.addGrimpeur(g);
		System.out.println("Entrez le nom de la sauvegarde");
		scan.reset();
		String fname = scan.nextLine();
		scan.close();
		Io.saveMainBoard(fname, mb);
	}
	public static void main(String[] args) {
		
		File saveFolder = new File(".");
		if (saveFolder.exists()) {// On verifie si un dossier de sauvegarde "saved" existe
			System.out.println("Bonjour, voici une liste des salles enregistrees :");
			try (Stream<Path> walk = Files.walk(Paths.get("."))) {
			List<String> result = walk.map(x -> x.toString())
					.filter(f -> f.endsWith(".mb")).collect(Collectors.toList());
			result.forEach(System.out::println);
			} catch (IOException e) {
			e.printStackTrace();
			}
			
		}
		
		mbselect();
	

	}

}
