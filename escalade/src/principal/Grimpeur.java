package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.sun.tools.javac.Main;

public class Grimpeur {
    private String pseudo;
    private int age;
    private Set<Voie> grimpes_types;
    private List<String> chaussons;
    private Niveau niveau;
    private List<Activite> hist;
    private Inbox inbox;
    public void addEssayee(Voie voie, String date, MainBoard mainBoard)  {
        Grimpe g = new Grimpe(this, voie, date);
        hist.add(g);
        voie.addGrimpe(g);
        List<Voie> voies = mainBoard.getVoies(); 
        voies.set(voie.getId(), voie);
        mainBoard.setVoies(voies);
    } 

}