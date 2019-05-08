package principal;

public class Annonce extends Activite {
    private Grimpeur auteur;
    private String msg;

    public Annonce(String date,Grimpeur auteur,String msg) {
        this.date=date;
        this.auteur=auteur;
        this.msg=msg;
    }

    
    //public void disp(){}
}