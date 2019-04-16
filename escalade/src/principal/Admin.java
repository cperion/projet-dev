package principal;

public interface Admin  { // on utilise une interface juste parcequ'on peut
    /**Do admin stuff*/
    public void fermerVoie();
    public void ouvrirVoie();
    public void addGrimpeur();
    public void delGrimpeur();
    public void addSecteur();
    public void delSecteur();
    public void addVoie();
    public void delVoie();
}