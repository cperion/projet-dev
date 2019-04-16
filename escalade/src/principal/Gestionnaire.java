package principal;

import java.util.List;

public class Gestionnaire {
    public void fermerVoie(Voie voie) {
        voie.setOuvert(false);
    }
    public void ouvrirVoie(Voie voie) {
        voie.setOuvert(true);
    }
    public void addGrimpeur(String pseudo, int age) {
        int id;
        id=MainBoard.getGrimpeurs().size(); // A chaque grimpeur on associe un id qui correspond à sa place dans la liste des grimpeurs
        Grimpeur g = new Grimpeur(id, pseudo, age);
        MainBoard.addGrimpeur(g);
    }
    public void delGrimpeur(int id) {
        MainBoard.delGrimpeur(id);
    }
    public void addSecteur(String nom) {
        Secteur s = new Secteur(nom);
        MainBoard.addSecteur(s);
    }
    public void delSecteur(int id) {
        MainBoard.delSecteur(id);
    }
    public void addVoie(String nom) {
        int id;
        id = MainBoard.getVoies().size();
        Voie v = new Voie(id, nom);
        MainBoard.addVoie(v);
    }
    public void delVoie(int id) {
        MainBoard.delVoie(id);
    }
}