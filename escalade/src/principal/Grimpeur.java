package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Lucas Dassin
 *
 */
public class Grimpeur {
    protected int id;
    private String pseudo;
    private int age;
    private List<Voie> preferees;
    private List<String> chaussons;
    private int niveau;
    private List<Activite> hist;
    private Inbox inbox;
    private List<Grimpeur> amis;
    private String signature = "";

    public Grimpeur(){}
    /**
     * 
     * @param id 	 Identifiant du grimpeur
     * @param pseudo Pseudonyme du grimpeur
     * @param age	 Age du grimpeur
     * @param niveau Niveau du grimpeur
     */
    public Grimpeur(int id, String pseudo, int age,int niveau)  {
        this.id = id;
        this.pseudo = pseudo;
        this.age = age;
        this.niveau = niveau;
        this.preferees= new ArrayList<Voie>();
        this.chaussons= new ArrayList<String>();
        this.hist= new ArrayList<Activite>();
        this.inbox= new Inbox();
        this.amis= new ArrayList<Grimpeur>();
    }
    /**
     * 
     * @param mb	  Salle où grimpe le grimpeur
     * @param voie	  Voie sur laquelle grimpe le grimpeur
     * @param date	  Date à laquelle le grimpeur grimpe la voie
     * @param reussie true s'il la réusit, false sinon
     * @param eval	  +1, 0 ou -1
     * @param com	  Commentaire laissé par le grimpeur sur la voie
     */
    public void addEssayee(MainBoard mb, Voie voie, String date, boolean reussie, int eval, String com)  {
        Grimpe g = new Grimpe(this, voie, date, reussie);
        hist.add(g); // On ajoute la grimpe à l'historique
        voie.addGrimpe(g); // On modifie la voie en lui ajoutant la grimpe à son historique
        if (eval == 1) {voie.up();}
        if (eval == -1) {voie.down();}
        voie.addCom(com, this.pseudo);
        List<Voie> voies = mb.getVoies(); // On extrait la liste des voies
        voies.set(voie.getId(), voie);// on remplace la voie originale par la voie modifiee
        mb.setVoies(voies); // Et on remplace la liste des voies originale par la liste modifiee
    }
        /**
     * 
     * @param voie Voie à ajouter à la liste des voies préférées
     */
    public void togglePreferee(Voie voie) { // Ajoute ou retire un voie preferee
        if (!preferees.contains(voie)) { // Il faut au prealable verfier si la voie n'est pas deja dans la liste des preferees
            preferees.add(voie);
        } else {
            preferees.remove(voie);
        }
    }
        /**
     * 
     * @param m Message de notification envoyé au grimpeur
     */
    public void addMessage(Message m) {
        inbox.addMessage(m);
    }
        /**
     * 
     * @param g	Grimpeur à ajouter à la liste d'amis
     */
    public void toggleAmi(Grimpeur g) {
        if (!amis.contains(g)) {
            amis.add(g);
        } else { amis.remove(g); }
    }
    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }
    /**
     * @return the hist
     */
    public List<Activite> getHist() {
        return hist;
    }
    /**
     * @return the amis
     */
    public List<Grimpeur> getAmis() {
        return amis;
    }
    /**
     * @param amis the amis to set
     */
    public void setAmis(List<Grimpeur> amis) {
        this.amis = amis;
    }
    /**
     * @return the preferees
     */
    public List<Voie> getPreferees() {
        return preferees;
    }

    public int getNiveau(){
        return this.niveau;
    }

    public void setNiveau(int niveau){
        this.niveau = niveau;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
        /**
     * @return Identifiant et pseudonyme du grimpeur
     */
    public String toString() {
        String out="";
        out += "id: " + Integer.toString(id) + "\n";
        out += "pseudo: " + pseudo + "\n";
        out += "age: " + Integer.toString(age) + "\n" ;
        out += "niveau: " + Integer.toString(niveau) + "\n";
        out += "signature: " + signature; // Eventuellement a completer
        return out;
    }
        /**
     * 
     * @return Nombre d'essais échoués sur la voie
     */
    public int nbEchecs(){
        int k=0;
        for (Activite e:hist){
            if (e instanceof Grimpe){
                Grimpe g = (Grimpe) (e);
                if(g.getReussite() == false){
                    k++;
                }
            }
        }
        return k;
    }
    /**
     * 
     * @return Nombre d'essais réussis sur la voie
     */
    public int nbSucces(){
        int k=0;
        for (Activite e:hist){
            if (e instanceof Grimpe){
                Grimpe g = (Grimpe) (e);
                if(g.getReussite() == true){
                    k++;
                }
            }
        }
        return k;
    }
    /**
     * 
     * @return Nombre d'essais sur la voie
     */
    public int nbEssais(){
        return nbSucces() + nbEchecs();
    }
    /**
     * 
     * @return Dernière voie grimpée
     */
    public Voie derniereGrimpe(){
        Collections.reverse(hist);
        for (Activite e:hist){
            if (e instanceof Grimpe){
                Grimpe g = (Grimpe) (e);
                return g.getVoie();
            }
        }
        System.out.println("Vous ne grimpez jamais !");
        return null;
    }
    /**
     * 
     * @return Niveau de difficulté le plus dur réalisé par le grimpeur
     */
    public
    public Integer plusDureGrimpe() {
        List<Integer> listeDiff = new ArrayList<Integer>();
        for (Activite e:hist){
            if (e instanceof Grimpe){
                Grimpe g = (Grimpe) (e);
                Voie v = g.getVoie();
                listeDiff.add(v.getDifficulte());
            }
        }
        if (listeDiff.size()==0) {
            return 0;
        }
        return Collections.max(listeDiff);
    }
    public void iddown(){
        id--;
    }
}
