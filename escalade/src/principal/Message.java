package principal;

public class Message {
    private String msg;
    private Grimpeur destinataire;
    private Grimpeur envoyeur;
    private boolean lu;
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