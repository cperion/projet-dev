package io;

import principal.*;
import io.Io;
import ui.cli.*;

public class Test {
    public static void main(String[] args) {
        //String fname = "test.mb";
        MainBoard mb = new MainBoard();
        Gestionnaire.addVoie("Bleu", "X", 12, mb);
        Gestionnaire.addVoie("Rouge", "Y", 1, mb);
        Gestionnaire.addVoie("Vert", "Z", 2, mb);
        Gestionnaire.addVoie("Renoi", "A", 3, mb);
        Gestionnaire.addGrimpeur("shatta", 21, 3, mb);
        Gestionnaire.addGrimpeur("marsu", 12, 15, mb);
        Gestionnaire.addGrimpeur("sonic", 7, 25, mb);
        Gestionnaire.addGrimpeur("jul", 2, 1, mb);
        //Io.saveMainBoard(fname, mb);
        //MainBoard mb2 = Io.loadMainBoard(fname);
        //System.out.println(mb2.hi);
        Mainloop.startconsole(mb, 0);
    }
       
}