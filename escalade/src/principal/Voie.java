package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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

    public Voie(int id, String nom, String secteur, int niveau) {
        this.secteur=secteur;
        this.id = id;
        this.nom= nom;
        this.difficulte = niveau;
    }
    
	public void up(){ eval++; } // incremente le compteur de difficulte
    public void down(){eval--;} // decremente le compeur de difficulte
    public void addCom(String com, String pseudo) {
        String out="";
        out +="----------" + "\n";
        out +="Auteur : " + nom + "\n";
        out += com + "\n";
        coms.add(out);
    }
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

    public int nbGrimpeur(){
        ArrayList<Grimpeur> listeGrimpeur = new ArrayList<Grimpeur>();
        for(Grimpe g:hist){
            listeGrimpeur.add(g.getGrimpeur());
            }
        HashSet distinctGrimpeur = new HashSet();
        distinctGrimpeur.addAll(listeGrimpeur);
        ArrayList<Grimpeur> nbGrimpeur = new ArrayList<Grimpeur>();
        return nbGrimpeur.size();
    }

    public Grimpeur dernierGrimpeur(){
        Collections.reverse(hist);
        for (Grimpe g:hist){
            return g.getGrimpeur();
            }
        System.out.println("Cette voie n'a pas encore été réalisée.");
        return null;
    }

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
    public int score(){
        return eval;
    }
    public double scoreMoy(){
        return (double)eval/(double)hist.size();
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