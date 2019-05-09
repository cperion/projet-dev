package principal;

import java.util.List;

public class Ouvreur extends Grimpeur {

    private List<Voie> ouvertes;
    private List<Voie> fermees;

    public Ouvreur(int id, String pseudo, int age,int niveau) {
        super(niveau, pseudo, niveau, niveau);
    }

    public void ouvre(int id, String nom, int niveau, MainBoard mb){
        Voie nouvelleVoie = new Voie(id,nom,niveau);
        mb.addVoie(nouvelleVoie);
    }

    public void ferme() {
        
    }
}