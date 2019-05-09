package principal;
import principal.Voie;

public class Grimpe extends Activite {
    private Grimpeur grimpeur;
    private Voie voie;
    private String date;
    private boolean reussie;

    
    public Grimpe(Grimpeur grimpeur,Voie voie,String date, boolean reussie) {
        this.grimpeur=grimpeur;
        this.voie=voie;
        this.date=date;
        this.reussie=reussie;
    }

    /**
     * @return the date
     */
 
    public String getDate() {
        return date;
    }
    /**
     *      
     * @return the voie
     */
    public Voie getVoie() {
        return voie;
    }
    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * @param voie the voie to set
     */
    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public boolean getReussite(){
        return this.reussie;
    }
    @Override
    public String toString() {
        String out="";
        out += "grimpeur: " + grimpeur.getPseudo() + "\n";
        out += "voie: " + voie.getNom() + "\n";
        out += "date: " + date + "\n";
        return out;
    }

}