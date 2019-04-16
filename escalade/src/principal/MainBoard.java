package principal;

import java.util.List;

public class MainBoard { // Le MainBoard est represente la physiqualite de la salle de sport
    static private List<Activite> activites;
    static private List<Voie> voies;
    static private List<Grimpeur> grimpeurs; // Le premier element de cette liste est le gestionnaire. C'est une liste non vide...
    static private List<Secteur> secteurs; // Redondant mais pratique
    /**
     * @return the voies
     */
    static public List<Voie> getVoies() {
        return voies;
    }
    /**
     * @param voies the voies to set
     */
    static public void setVoies(List<Voie> lvoies) {
        voies = lvoies;
    }
    /**
     * @return the grimpeurs
     */
    static public List<Grimpeur> getGrimpeurs() {
        return grimpeurs;
    }
    /**
     * @param grimpeurs the grimpeurs to set
     */
    static public void setGrimpeurs(List<Grimpeur> grimpeurs) {
        MainBoard.grimpeurs = grimpeurs;
    }
    static public void addGrimpeur(Grimpeur g)  {
        grimpeurs.add(g);
    }
    static public void delGrimpeur(int id) {
        grimpeurs.remove(id);
    }

    static public void addSecteur(Secteur s) {
        secteurs.add(s);
    }
    static public void delSecteur(int id) {
        secteurs.remove(id);
    }
    static public void addVoie(Voie v)  {
        voies.add(v);
    }
    static public void delVoie(int id) {
        voies.remove(id);
    }
}