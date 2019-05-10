package principal;

import java.security.MessageDigest;
/**
 * 
 * @author Cédric Perion
 *
 */
public class Gestionnaire extends Grimpeur {
	    /**
     * 
     * @param voie Voie à fermer
     */
    public Gestionnaire() {
        super();
        this.id=0;
    }
    /**
     * 
     * @param voie Voie à ouvrir
     */	
    static public void fermerVoie(Voie voie) {
        voie.setOuvert(false);
    }
    /**
     * 
     * @param pseudo Pseudonyme du grimpeur à ajouter
     * @param age	 Age du grimpeur
     * @param niveau Niveau du grimpeur
     * @param mb	 MainBoard dans lequel va être ajouté le grimpeur
     */	
    public void ouvrirVoie(Voie voie) {
        voie.setOuvert(true);
    }
    /**
     * 
     * @param id Identifiant du grimpeur à enlever de la salle
     * @param mb Salle d'où le grimpeur est enlevé
     */	
    static public void addGrimpeur(String pseudo, int age, int niveau, MainBoard mb) {
        int id;
        id=mb.getGrimpeurs().size(); // A chaque grimpeur on associe un id qui correspond à sa place dans la liste des grimpeurs
        Grimpeur g = new Grimpeur(id, pseudo, age, niveau);
        mb.addGrimpeur(g);
    }
    /**
     * 
     * @param nom Nom du secteur à ajouter
     * @param mb  Salle où est ajouté le secteur
     */	
    static public void delGrimpeur(int id, MainBoard mb) {
        mb.delGrimpeur(id);
    }
    /**
     * 
     * @param id Identifiant du secteur à enlever de la salle
     * @param mb Salle d'où l'on retire le secteur
     */
    static public void addVoie(String nom, String secteur, int niveau, MainBoard mb) {
        int id;
        id = mb.getVoies().size();
        Voie v = new Voie(id, nom, secteur, niveau);
        mb.addVoie(v);
    }
	    /**
     * 
     * @param nom	 Nom de la voie à ajouter
     * @param niveau Niveau de la voie à ajouter
     * @param mb	 Salle d'où l'on ajoute la voie
     */
    static public void delVoie(int id, MainBoard mb) {
        mb.delVoie(id);
    }
	    /**
     * 
     * @param id Identifiant de la voie à supprimer
     * @param mb Salle d'où l'on retire la voie
     */
    static public void setPass(int id, String mdp, MainBoard mb) {
        byte[] hash = "".getBytes();
        try { MessageDigest mdigest = MessageDigest.getInstance("SHA-256");
				hash = mdigest.digest(mdp.getBytes());
		} catch (Exception e) {
				e.printStackTrace();
        }
        mb.setHash(id, hash);
    }
}
