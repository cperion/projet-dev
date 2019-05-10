package principal;

public class Gestionnaire extends Grimpeur{
    public Gestionnaire() {
        super();
        this.id=0;
    }
    static public void fermerVoie(Voie voie) {
        voie.setOuvert(false);
    }
    public void ouvrirVoie(Voie voie) {
        voie.setOuvert(true);
    }
    static public void addGrimpeur(String pseudo, int age, int niveau, MainBoard mb) {
        int id;
        id=mb.getGrimpeurs().size(); // A chaque grimpeur on associe un id qui correspond à sa place dans la liste des grimpeurs
        Grimpeur g = new Grimpeur(id, pseudo, age, niveau);
        mb.addGrimpeur(g);
    }
    static public void delGrimpeur(int id, MainBoard mb) {
        mb.delGrimpeur(id);
    }

    static public void addVoie(String nom, String secteur, int niveau, MainBoard mb) {
        int id;
        id = mb.getVoies().size();
        Voie v = new Voie(id, nom, secteur, niveau);
        mb.addVoie(v);
    }
    static public void delVoie(int id, MainBoard mb) {
        mb.delVoie(id);
    }
}