package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Grimpeur {
    private int id;
    private String pseudo;
    private int age;
    private List<Voie> preferees;
    private List<String> chaussons;
    private Niveau niveau;
    private List<Activite> hist;
    private Inbox inbox;

    public Grimpeur(int id, String pseudo, int age)  {
        this.id = id;
        this.pseudo = pseudo;
        this.age = age;
        this.preferees= new ArrayList<Voie>();
        this.chaussons= new ArrayList<String>();
        this.niveau= Niveau.base;
        this.hist= new ArrayList<Activite>();
        this.inbox= new Inbox();
    }

    public void addEssayee(Voie voie, String date, boolean reussie)  {
        Grimpe g = new Grimpe(this, voie, date, reussie);
        hist.add(g); // On ajoute la grimpe à l'historique
        voie.addGrimpe(g); // On modifie la voie en lui ajoutant la grimpe à son historique
        List<Voie> voies = MainBoard.getVoies(); // On extrait la liste des voies
        voies.set(voie.getId(), voie);// on remplace la voie originale par la voie modifiee
        MainBoard.setVoies(voies); // Et on remplace la liste des voies originale par la liste modifiee
    }
    public void addPreferee(Voie voie) { // Ajoute un voie preferee
        if (!preferees.contains(voie)) { // Il faut au prealable verfier si la voie n'est pas deja dans la liste des preferees
            preferees.add(voie);
        }
        preferees.add(voie);
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

    @Override
    public String toString() {
        String out="";
        out += "pseudo: " + pseudo + "\n";
        out += "age: " + Integer.toString(age) + "\n"; // Eventuellement a completer
        return out;
    }
}