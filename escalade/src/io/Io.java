package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import principal.MainBoard;
/**
 * 
 * @author Cédric Perion
 *
 */
public class Io { //Sauvegearde la salle avec tout ce qu'elle contient
	/**
	 * 
	 * @param fname Nom du fichier où l'on sauvegarde les informations sur la salle
	 * @param mb    Salle d'escalade
	 */
    public static void saveMainBoard(String fname, MainBoard mb) {
        try {
            if (!fname.endsWith(".mb")) {
                fname += ".mb";
            }
            //fname= "./saved/" + fname;
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
            oos.writeObject(mb);
            oos.close();
            System.out.println("Ecriture de la sauvegarde reussie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @param fname	Nom du fichier à charger
     * @return		Salle d'escalade concerné par le fichier
     */
    public static MainBoard loadMainBoard(String fname) {
        try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
            MainBoard mb = (MainBoard) ois.readObject();
            ois.close();
            System.out.println("Chargment de la sauvegarde reussi");
            return mb;
			
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
    }
}
