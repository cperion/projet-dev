package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
    public void addPreferee(Voie voie) { // Ajoute un voie preferee
        if (!preferees.contains(voie)) { // Il faut au prealable verfier si la voie n'est pas deja dans la liste des preferees
            preferees.add(voie);
        }
        preferees.add(voie);
    }
    public void addMessage(Message m) {
        inbox.addMessage(m);
    }
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

    @Override
    public String toString() {
        String out="";
        out += "id: " + Integer.toString(id) + "\n";
        out += "pseudo: " + pseudo + "\n";
        out += "age: " + Integer.toString(age) + "\n" ;
        out += "niveau: " + Integer.toString(niveau) + "\n";
        out += "signature: " + signature; // Eventuellement a completer
        return out;
    }
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

    public int nbEssais(){
        return nbSucces() + nbEchecs();
    }

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

    public Integer plusDureGrimpe() {
        List<Integer> listeDiff = new ArrayList<Integer>();
        for (Activite e:hist){
            if (e instanceof Grimpe){
                Grimpe g = (Grimpe) (e);
                Voie v = g.getVoie();
                listeDiff.add(v.getDifficulte());
            }
        }
        return Collections.max(listeDiff);
    }
}