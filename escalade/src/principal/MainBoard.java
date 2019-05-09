package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainBoard implements Serializable{ // Le MainBoard est represente la physiqualite de la salle de sport
    private List<Activite> activites;
    private List<Voie> voies;
    private List<Grimpeur> grimpeurs; // Le premier element de cette liste est le gestionnaire. C'est une liste non vide...
    private List<Secteur> secteurs; // Redondant mais pratique
    private List<byte[]> hashlist;

    public MainBoard() {
        grimpeurs= new ArrayList<Grimpeur>();
    }
    /**
     * @return the voies
     */
    public List<Voie> getVoies() {
        return voies;
    }
    /**
     * @param voies the voies to set
     */
    public void setVoies(List<Voie> lvoies) {
        voies = lvoies;
    }
    /**
     * @return the grimpeurs
     */
    public List<Grimpeur> getGrimpeurs() {
        return grimpeurs;
    }
    /**
     * @param grimpeurs the grimpeurs to set
     */
    public void setGrimpeurs(List<Grimpeur> grimpeurs) {
        this.grimpeurs = grimpeurs;
    }
    public void addGrimpeur(Grimpeur g)  {
        grimpeurs.add(g);
    }
    public void delGrimpeur(int id) {
        grimpeurs.remove(id);
    }

    public void addSecteur(Secteur s) {
        secteurs.add(s);
    }
    public void delSecteur(int id) {
        secteurs.remove(id);
    }
    public void addVoie(Voie v)  {
        voies.add(v);
    }
    public void delVoie(int id) {
        voies.remove(id);
    }
    public void addAnonce(Annonce a) {
        activites.add(a);
    }
    public void addEvenement(Evenement e) {
        activites.add(e);
    }
    /**
     * @return the hashlist
     */
    public List<byte[]> getHashlist() {
        return hashlist;
    }
    /**
     * @return the activites
     */
    public List<Activite> getActivites() {
        return activites;
    }

    
	public void setGrimpeur(int id, Grimpeur g) {
        grimpeurs.set(id, g);
	}
}