package ui.cli;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import principal.MainBoard;

public class Mainloop {

	public static void startconsole(MainBoard mb, int id) {}
	public static  void startadminconsole(MainBoard mb) {}

	public static void start(MainBoard mb, int id) {
		if (id == 0) {
			System.out.println("God mode");
			startadminconsole(mb);
		} else startconsole(mb, id);

	}

	public static void login(MainBoard mb) {
		byte[] hash = "".getBytes();
		int id;
		boolean go = false;
		do {
			System.out.println("Entrez votre id");
			Scanner scan = new Scanner(System.in);
			id = scan.nextInt();
			//scan.close();
			//Scanner scan = new Scanner(System.in);
			String mdp = scan.nextLine();
			try { MessageDigest mdigest = MessageDigest.getInstance("SHA-256");
				hash = mdigest.digest(mdp.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Voulez vous continuer ? Y/N");
			String s=scan.nextLine();
			go = s=="Y" || s=="y" ;
		} while (mb.getHashlist().get(id) != hash || !go );
		start(mb, id);

		
	}
	public static void mbload(String fname) {
		try  { 
			FileInputStream fis = new FileInputStream(fname);
			ObjectInputStream ois = new ObjectInputStream(fis);
			MainBoard mb = (MainBoard) ois.readObject();
			login(mb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void mbselect() {
		System.out.println("Entrez le nom du fichier de sauvegarde à charger :");
		Scanner scan = new Scanner(System.in);
		String fname = new String();
		fname = scan.next();
		scan.close();
		mbload(fname);
	}
	public static void main(String[] args) {
		
		File saveFolder = new File("./saved");
		if (saveFolder.exists()) {// On verifie si un dossier de sauvegarde "saved" existe
			System.out.println("Bonjour, voici une liste des salles enregistrees :");
			try (Stream<Path> walk = Files.walk(Paths.get("./saved"))) {
			List<String> result = walk.map(x -> x.toString())
					.filter(f -> f.endsWith(".mb")).collect(Collectors.toList());
			result.forEach(System.out::println);
			} catch (IOException e) {
			e.printStackTrace();
			}
			
		}
		else {// Si il n'existe pas on essaie de le créer
			System.out.println("Création du dossier de sauvegarde");
			try { File dir = new File("saved");
				dir.mkdir();
			} catch (Exception e) {
					System.out.println("Une erreur s'est produite !");
					e.printStackTrace();
			}
		}
	

	}

}
