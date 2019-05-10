package ui.cli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import principal.Activite;
import principal.Annonce;
import principal.Evenement;
import principal.Grimpeur;
import principal.MainBoard;
import principal.Message;
import principal.Util;
import principal.Voie;


public class Command {
    String command;
    List<String> params= new ArrayList<String>();
    public Command(String line) {
        String[] splitted = line.split(" ");
        this.command=splitted[0];
        int n = splitted.length;
        int k=1;
        while (n>k) {
            params.add(splitted[k]);
            k++;
        }
    }
    public int exec(MainBoard mb, int id) {
        int out = 0;
        switch (command) {
            case "help":{
                if (params.size() == 0) {
                    try {
                        BufferedReader in = new BufferedReader(new FileReader("helpfile"));
                        String line;
                        while((line = in.readLine()) != null){
                            System.out.println(line);
                        }
                        in.close();
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Trop d'arguments !");
                }
                break;
            }
            case "annonce": {
                if (params.size() == 2){
                    String date = params.get(0);
                    if (Util.okDate(date)) {
                        String message = params.get(1);
                        Grimpeur auteur = mb.getGrimpeurs().get(id);
                        Annonce a = new Annonce(date, auteur, message);
                        mb.addAnonce(a);
                        System.out.println("----------");
                        System.out.println("L'annonce a bien ete ajoutee au MainBoard");
                        System.out.println("----------");
                        System.out.println(mb.getActivites().get(mb.getActivites().size()-1).toString());
                        System.out.println("----------");
                    }
                } else {
                    System.out.println("Mauvais nombre d'arguments pour annonce");
                }
                break;
            
            }
            case "annonces" : {
                if (params.size()==0) {
                    List<Activite> activites = mb.getActivites();
                    List<Annonce> annonces = new ArrayList<Annonce>();
                    for (Activite a : activites ) {
                        if ( a instanceof Annonce) {
                            Annonce an = (Annonce) a; // On cast l'activite a en annonce an
                            annonces.add(an);
                        }
                    }
                    for (Annonce a : annonces) {
                        System.out.println("----------");
                        System.out.println(a.toString());
                        System.out.println("----------");
                    }
                }
                break;
            }
            case "voie": {
                if (params.size() == 1) {
                    int idVoie = Util.idfromnom(mb, params.get(0));
                    System.out.println(mb.getVoies().get(idVoie).toString());
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "profil": {
                if (params.size() == 1) {
                    try {
                        int idGrimpeur = Util.idfrompseudo(mb, params.get(0));
                        System.out.println("----------");
                        System.out.println(mb.getGrimpeurs().get(idGrimpeur).toString());
                        System.out.println("----------");
                    } catch (Error e) {
                        e.printStackTrace();
                    }
                    
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "evenements": {
                if (params.size() == 0) {
                    Fonctions.evenements(mb);   
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "essayee": {
                if (params.size() == 4) {
                    int idVoie = Util.idfromnom(mb, params.get(0));
                    String date = params.get(1);
                    boolean reussie = false;
                    if (params.get(2) == "Y") { reussie = true; }
                    int eval = Integer.parseInt(params.get(3));
                    
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "preferee": {
                if (params.size()==1) { 
                    int idVoie = Util.idfromnom(mb, params.get(0));
                    Voie voie = mb.getVoies().get(idVoie);
                    Grimpeur g = mb.getGrimpeurs().get(id);   
                    g.addPreferee(voie);
                    mb.setGrimpeur(id, g);
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "evenement": {
                if (params.size()==4) {
                    String date = params.get(0);
                    String duree = params.get(1);
                    String lieu = params.get(2);
                    String message = params.get(3);
                    Evenement e = new Evenement(date, duree, lieu, message);
                    mb.addEvenement(e);
                    //en travaux
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "msg": {
                if (params.size()==1){
                    int idDest = Util.idfrompseudo(mb, params.get(0));
                    Grimpeur dest = mb.getGrimpeurs().get(idDest);
                    Grimpeur env = mb.getGrimpeurs().get(id);
                    Message m = new Message(env, dest, params.get(0));
                    dest.addMessage(m);
                    if (idDest < mb.getGrimpeurs().size()) {
                        mb.setGrimpeur(idDest, dest);
                    } else {
                        System.out.println("Il y a une erreur sur le destinataire");
                    }
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
                
            }
            case "amis": {
                if (params.size()== 1) {
                    int idami = Util.idfrompseudo(mb, params.get(0));
                    Grimpeur ami = mb.getGrimpeurs().get(idami); // Le grimpeur dont on veut ajouter l'ami
                    Grimpeur g = mb.getGrimpeurs().get(id);
                    ami.toggleAmi(g);
                    g.toggleAmi(ami);
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "rprofil"  : {
                if (params.size()== 1) {
                    String s = params.get(0);
                    List<Grimpeur> result = Util.resProfil(mb, s);
                    for (Grimpeur g : result ) {
                        System.out.println("----------");
                        System.out.println(g.toString());
                    }
                }
                break;
            }
            default : {
                System.out.println("Commande invalide");
            }
        }
        return out;
    }
}