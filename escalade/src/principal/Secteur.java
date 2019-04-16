package principal;

import java.util.ArrayList;
import java.util.List;

import sun.tools.tree.ArrayAccessExpression;

public class Secteur {
    private String nom;
    private List<Voie> voies; // Chaque secteur contient une liste de voies, oui c'est redondant on sait

    public Secteur(String nom)  {
        this.nom =nom;
        this.voies = new ArrayList<Voie>();
    }
}