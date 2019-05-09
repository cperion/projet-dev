package principal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        MainBoard mb = new MainBoard();

        try { 
        File savefile = new File("test.mb");
        savefile.createNewFile();
        FileOutputStream fis =  new FileOutputStream("test.mb");
        
        ObjectOutputStream os = new ObjectOutputStream(fis);
        os.writeObject(mb);
        os.close();
        System.out.println("Ecriture de la sauvegarde reussie");
        } catch (Exception e) {
            e.printStackTrace();
        }
=======
        double a;
        System.out.println("Hello World");
>>>>>>> bd95591d36adabb0f9e9854ffd3f1233ff786c83
    }
}