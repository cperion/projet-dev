package principal;

import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Util {
    public static int idfrompseudo(MainBoard mb, String pseudo ) {
        List<Grimpeur> grimpeurs=mb.getGrimpeurs();
        boolean found = false;
        int id=0;
        int n = grimpeurs.size();
        while (!found  && id<n) {
            if (!pseudo.equals(grimpeurs.get(id).getPseudo())){
            id++;
            } else {
                found = true;
                return id;
            }
        }
        throw new Error("Pseudo introuvable"); // C'est qu'il y a eu une erreur
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
    public static List<Grimpeur> resProfil(MainBoard mb, String s) { // Donne la liste des grimpeurs dont le pseudo contient la chaîne s
        List<Grimpeur> grimpeurs = mb.getGrimpeurs();
        List<Grimpeur> result = new ArrayList<Grimpeur>();
        for (Grimpeur g : grimpeurs) {
            if (g.getPseudo().contains(s)) {
                result.add(g);
            }
        }
        return result;
    }
    public static boolean okDate(String date){
        // if (date.length() != 8) {
        //     return false;
        // }
        // String jour = date.substring(0, 2);
        // String mois = date.substring(2, 4);
        // String annee = date.substring(4, 8);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(date);
            return true;
        } catch (ParseException e) {
            System.out.println("La date " + date + " n'est pas valide ou ne respecte pas le format " +
                ((SimpleDateFormat) format).toPattern());
            return false;
        }

    }
}