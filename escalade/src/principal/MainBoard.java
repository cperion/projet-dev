package principal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class MainBoard implements Serializable{ // Le MainBoard est represente la physiqualite de la salle de sport
    private List<Activite> activites;
    private List<Voie> voies;
    private List<Grimpeur> grimpeurs; // Le premier element de cette liste est le gestionnaire. C'est une liste non vide...
    private List<Secteur> secteurs; // Redondant mais pratique
    private List<byte[]> hashlist;
    /**
     * @return the voies
     */
    public List<Voie> getVoies() {
        return voies;
    }
    /**
     * @param voies the voies to set
     */
    public void setVoies(List<Voie> lvoies) {
        voies = lvoies;
    }
    /**
     * @return the grimpeurs
     */
    public List<Grimpeur> getGrimpeurs() {
        return grimpeurs;
    }
    /**
     * @param grimpeurs the grimpeurs to set
     */
    public void setGrimpeurs(List<Grimpeur> grimpeurs) {
        this.grimpeurs = grimpeurs;
    }
    public void addGrimpeur(Grimpeur g)  {
        grimpeurs.add(g);
    }
    public void delGrimpeur(int id) {
        grimpeurs.remove(id);
    }

    public void addSecteur(Secteur s) {
        secteurs.add(s);
    }
    public void delSecteur(int id) {
        secteurs.remove(id);
    }
    public void addVoie(Voie v)  {
        voies.add(v);
    }
    public void delVoie(int id) {
        voies.remove(id);
    }
    public void addAnonce(String date, String msg, int id) {
        Grimpeur auteur = grimpeurs.get(id);
        Annonce a = new Annonce(date, auteur, msg);
        activites.add(a);
    }

    /**
     * @return the hashlist
     */
    public List<byte[]> getHashlist() {
        return hashlist;
    }

    public void save(String fname) { // Sauvegarde la salle dans un fichier
        try {
            if (!fname.endsWith(".mb")) {
                fname += ".mb";
            }
            fname= "./saved/" + fname;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fname));
            os.writeObject(this);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}