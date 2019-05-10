package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class MainBoard implements Serializable{// Le MainBoard est represente aussi la physiqualite de la salle de sport
    private static final long serialVersionUID = 2L;
    private List<Activite> activites = new ArrayList<Activite>();
    private List<Voie> voies = new ArrayList<Voie>();
    private List<Grimpeur> grimpeurs = new ArrayList<Grimpeur>(); // Le premier element de cette liste est le gestionnaire. C'est une liste non vide...
    //private List<Secteur> secteurs = new ArrayList<Secteur>(); // Redondant mais pratique
    private List<byte[]> hashlist = new ArrayList<byte[]>(); // stock les digest SHA 256 des mots de passe des utilisateurs
    public String hi = "hi"; // Variable bien élevée.

//    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("hi", String.class)};



    public MainBoard() {
        Grimpeur g = new Grimpeur(0, "admin", 999, 100);
        String mdp = "passwd";
        byte[] hash = "".getBytes();
        try { MessageDigest mdigest = MessageDigest.getInstance("SHA-256");
			hash = mdigest.digest(mdp.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
        this.grimpeurs= new ArrayList<Grimpeur>();
        this.grimpeurs.add(g);
        this.hashlist.add(hash);
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
        int n = grimpeurs.size();
        if (id+1<n) { List<Grimpeur> down = grimpeurs.subList(id+1, n); } //il faut changer l'id des grimpeurs après celui qui a été supprimé !
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

    public void setVoie(int id, Voie v) {
        voies.set(id, v);
    }
    
    public void setHash(int id, byte[] hash) {
        if ( id == hashlist.size()) {
            hashlist.add(hash);
        }
        if ( id < hashlist.size()) {
            hashlist.set(id, hash);
        }
    }
}