package principal;
import principal.Voie;

public class Grimpe extends Activite {
    private Grimpeur grimpeur;
    private Voie voie;
    private String date;

    
    public Grimpe(Grimpeur grimpeur,Voie voie,String date) {
        this.grimpeur=grimpeur;
        this.voie=voie;
        this.date=date;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
    /**
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

}