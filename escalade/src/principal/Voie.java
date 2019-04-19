package principal;

import java.util.List;

public class Voie {
    private int id; //Identifiant unique qui permet de retrouver la voie dans la liste de voies du MainBoard
    private String nom;
    private Difficulte difficulte;
    private List<Grimpe> hist;
    private Horaire horaire;
    private String type;
    private boolean ouvert;
    private Secteur secteur;

    public Voie(int id, String nom) {
        this.id = id;
        this.nom= nom;
    }

    public void addGrimpe(Grimpe g) {
        hist.add(g);
    }
    /**
     * @return the id
     */
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
    
}