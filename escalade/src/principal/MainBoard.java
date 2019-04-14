package principal;

import java.util.List;

public class MainBoard {
    private List<Activite> activites;
    private List<Voie> voies;

    /**
     * @return the voies
     */
    public List<Voie> getVoies() {
        return voies;
    }
    /**
     * @param voies the voies to set
     */
    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }
}