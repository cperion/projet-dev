package principal;

import java.util.List;

public class Ouvreur extends Grimpeur {

    private List<Voie> ouvertes;
    private List<Voie> fermees;

    public Ouvreur(int id, String pseudo, int age,int niveau) {
        super(niveau, pseudo, niveau, niveau);
    }

    static public void ouvre(int id, MainBoard mb){
        Voie voie = mb.getVoies().get(id);
        voie.setOuvert(true);
        mb.setVoie(id, voie);
    }

    static public void ferme(int id, MainBoard mb) {
        Voie voie = mb.getVoies().get(id);
        voie.setOuvert(false);
        mb.setVoie(id, voie);
    }
}