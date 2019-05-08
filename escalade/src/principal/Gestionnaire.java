package principal;

public class Gestionnaire extends Grimpeur{
    public void fermerVoie(Voie voie) {
        voie.setOuvert(false);
    }
    public void ouvrirVoie(Voie voie) {
        voie.setOuvert(true);
    }
    public void addGrimpeur(String pseudo, int age, MainBoard mb) {
        int id;
        id=mb.getGrimpeurs().size(); // A chaque grimpeur on associe un id qui correspond à sa place dans la liste des grimpeurs
        Grimpeur g = new Grimpeur(id, pseudo, age);
        mb.addGrimpeur(g);
    }
    public void delGrimpeur(int id, MainBoard mb) {
        mb.delGrimpeur(id);
    }
    public void addSecteur(String nom, MainBoard mb) {
        Secteur s = new Secteur(nom);
        mb.addSecteur(s);
    }
    public void delSecteur(int id, MainBoard mb) {
        mb.delSecteur(id);
    }
    public void addVoie(String nom, MainBoard mb) {
        int id;
        id = mb.getVoies().size();
        Voie v = new Voie(id, nom);
        mb.addVoie(v);
    }
    public void delVoie(int id, MainBoard mb) {
        mb.delVoie(id);
    }
}