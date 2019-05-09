package principal;

public class Evenement extends Activite{
    private String duree;
    private String lieu;
    //private String msg;
    public Evenement(String date, String duree, String lieu, String msg ) {
        super();
        this.date = date;
        this.duree=duree;
        this.lieu=lieu;
        this.msg=msg;
    }
    @Override public String toString() {
        String out = super.toString();
        out += "duree " + duree + "\n";
        out += "lieu: " + lieu + "\n";
        return out;
    }
}