package principal;

import java.util.List;

public class Util {
    public static int idfrompseudo(MainBoard mb, String pseudo ) {
        List<Grimpeur> grimpeurs=mb.getGrimpeurs();
        boolean found = false;
        int id=0;
        while (!found) {
            if (pseudo != grimpeurs.get(id).getPseudo()){
            id++;
            } else {
                return id;
            }
        }
        return grimpeurs.size(); // C'est qu'il y a eu une erreur
    }
    public static int idfromnom(MainBoard mb, String nom ) {
        List<Voie> voies=mb.getVoies();
        boolean found = false;
        int id=0;
        while (!found) {
            if (nom != voies.get(id).getNom()){
            id++;
            } else {
                return id;
            }
        }
        return voies.size(); // C'est qu'il y a eu une erreur
    }
}