package principal;

public class Annonce extends Activite {
    private Grimpeur auteur;
    //private String msg;

    public Annonce(String date,Grimpeur auteur,String msg) {
        this.date=date;
        this.auteur=auteur;
        this.msg=msg;
    }

    @Override
    public String toString() {
        String out = "";
        out += "date: " + date + "\n";
        out += "auteur: " + auteur.getPseudo() +"\n";
        out += "message: " + msg;
        return out;
    }
    
    //public void disp(){}
}