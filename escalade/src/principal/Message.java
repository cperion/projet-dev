package principal;

public class Message {
    private String msg;
    private Grimpeur destinataire;
    private Grimpeur envoyeur;
    private boolean lu; //inutile pour le moment

    public Message(Grimpeur envoyeur, Grimpeur destinataire, String msg) {
        this.msg=msg;
        this.destinataire=destinataire;
        this.envoyeur=envoyeur;
    }
    /**
     * @return the destinataire
     */
    public Grimpeur getDestinataire() {
        return destinataire;
    }/**
     * @return the envoyeur
     */
    public Grimpeur getEnvoyeur() {
        return envoyeur;
    }/**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
}