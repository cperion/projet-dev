package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
/**
 * 
 * @author Enzo Corvi
 *
 */
public class Voie {
    private int id; //Identifiant unique qui permet de retrouver la voie dans la liste de voies du MainBoard
    private String nom;
    private int difficulte;
    private List<Grimpe> hist = new ArrayList<Grimpe>();
    private Horaire horaire;
    private String type;
    private boolean ouvert;
    private String secteur;
    private int eval; // Compteur de difficulte
    private List<String> coms = new ArrayList<String>();
    /**
     * 
     * @param id	 Identifiant de la voie
     * @param nom	 Nom de la voie
     * @param niveau Niveau de difficulté de la voie
     */
    public Voie(int id, String nom, String secteur, int niveau) {
        this.secteur=secteur;
        this.id = id;
        this.nom= nom;
        this.difficulte = niveau;
    }
    
	public void up(){ eval++; } // incremente le compteur de difficulte
    public void down(){eval--;} // decremente le compeur de difficulte
    /**
     * 
     * @param com	 Commentaire à laisser sur la voie
     * @param pseudo Pseudonyme du grimpeur laissant le commentaire
     */	
    public void addCom(String com, String pseudo) {
        String out="";
        out +="----------" + "\n";
        out +="Auteur : " + nom + "\n";
        out += com + "\n";
        coms.add(out);
    }
    /**
     * 
     * @param g Grimpeur à ajouter à la liste des grimpeurs grimpant la voie
     */	
    public void addGrimpe(Grimpe g) {
        hist.add(g);
    }
    /**
     * @return the id
     */

    public String getVoie(){
        return this.nom;
    }

    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param ouvert the ouvert to set
     */
    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }

    public int getDifficulte(){
        return this.difficulte;
    }
    /**
     * 
     * @return	Nombre de grimpeurs ayant grimpé la voie
     */
    public int nbGrimpes(){
        return hist.size();
    }
    /**
     * 
     * @return Dernier grimpeur ayant grimpé la voie
     */
    public Grimpeur dernierGrimpeur(){
        Collections.reverse(hist);
        for (Grimpe g:hist){
            return g.getGrimpeur();
            }
        System.out.println("Cette voie n'a pas encore été réalisée.");
        return null;
    }
    /**
     * 
     * @return Taux de réussite de la voie
     */
    public double tauxReussite(){
        int essai = 0;
        int succes = 0;
        for (Grimpe g:hist){
            essai++;
            if (g.getReussite() == true){
                succes++;
            }
        }
        return (double)succes/(double)essai;
    }
	    /**
     * 
     * @return +1, 0 ou -1
     */
    public int score(){
        return eval;
    }
	    /**
     * @return Evaluation moyenne
     */
    public double scoreMoy(){
        return (double)eval/(double)hist.size();
    }

    public void iddown(){
        id = id - 1;
    }

    @Override
    public String toString() {
        String out= "";
        out += "id : " + Integer.toString(id) + "\n";
        out += "nom : " + nom + "\n";
        out += "difficulte : " + Integer.toString(difficulte) + "\n";
        out += "secteur : " + secteur + "\n";
        if (ouvert) { out += "ouverte"; } else { out += "fermee"; }
        return out;
    }
}
