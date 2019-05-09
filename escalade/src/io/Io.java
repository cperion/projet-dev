package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import principal.MainBoard;

public class Io { //SAuvegearde la salle avec tout ce qu'elle contient
    public static void saveMainBoard(String fname, MainBoard mb) {
        try {
            if (!fname.endsWith(".mb")) {
                fname += ".mb";
            }
            //fname= "./saved/" + fname;
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fname));
            
            os.writeObject(mb);
            os.close();
            System.out.println("Ecriture de la sauvegarde reussie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}