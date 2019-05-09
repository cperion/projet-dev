package ui.cli;

import java.util.List;

import principal.Activite;
import principal.Evenement;
import principal.MainBoard;

public class Fonctions {
    public static void evenements ( MainBoard mb) {
        List<Activite> activites = mb.getActivites();
        String out ="";
        for (Activite a : activites) {
            if (a instanceof Evenement) {
                out += "---------------";
                out += a.toString();
            }
        }
        System.out.println(out);
    }
}