package principal;

public abstract class Activite {
    protected String date;
    protected String msg;
    @Override
    public String toString() {
        String out="";
        out += "date: " + date + "\n";
        out += "message: " + msg + "\n";
        return out;
    }
}