package ui.cli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



import principal.Activite;
import principal.Annonce;
import principal.Evenement;
import principal.Gestionnaire;
import principal.Grimpe;
import principal.Grimpeur;
import principal.MainBoard;
import principal.Message;
import principal.Ouvreur;
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
        //Gestionnaire admin = (Gestionnaire) mb.getGrimpeurs().get(0); //On instencie un administrateur pour plus tard
        Grimpeur g = mb.getGrimpeurs().get(id);
        boolean ouvreur = g instanceof Ouvreur; // Si le grimpeur est un ouvreur il pourra executer certaines commandes
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
                    System.out.println("----------");
                    System.out.println(mb.getVoies().get(idVoie).toString());
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "voies": {
                if (params.size()==0) {
                    List<Voie> voies = mb.getVoies();
                    for (Voie v : voies) {
                        System.out.println("----------");
                        System.out.println(v.toString());
                    }
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
                    
                } else if(params.size() == 0) {
                    System.out.println("----------");
                    System.out.println(mb.getGrimpeurs().get(id).toString());
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "evenements": {
                if (params.size() == 0) {
                    List<Activite> activites = mb.getActivites();
                    String str = new String();
                    for (Activite a : activites) {
                        if (a instanceof Evenement) {
                            str += "---------------" + "\n";
                            str += a.toString();
                        }
                    }
                    System.out.println(str);
                } else {
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "essayee": {
                if (params.size() == 5) {
                    try {
                        int idVoie = Util.idfromnom(mb, params.get(0));
                        String date = params.get(1);
                        boolean reussie = false;
                        if (params.get(2).equals("Y")) { reussie = true; }
                        int eval = Integer.parseInt(params.get(3));
                        String com = params.get(4);
                        //Grimpeur g = mb.getGrimpeurs().get(id);
                        Voie voie = mb.getVoies().get(idVoie);
                        g.addEssayee(mb, voie, date, reussie, eval, com);
                        mb.setGrimpeur(id, g);
                        System.out.println("----------");
                        System.out.println("Grimpe enregistree avec succes");
                    } catch (Error e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }

            case "preferee": {
                if (params.size()==1) { 
                    try {
                        int idVoie = Util.idfromnom(mb, params.get(0));
                        Voie voie = mb.getVoies().get(idVoie);
                        //Grimpeur g = mb.getGrimpeurs().get(id);   
                        g.togglePreferee(voie);
                        mb.setGrimpeur(id, g);
                        System.out.println("----------");
                        System.out.println("Voie preferee ajoutee avec succes");
                    } catch (Error e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "preferees": {
                if (params.size()==0) {
                    //Grimpeur g = mb.getGrimpeurs().get(id);
                    List<Voie> preferees = g.getPreferees();
                    for ( Voie v : preferees) {
                        System.out.println("----------");
                        System.out.println(v.toString());
                    }
                } else {
                    System.out.println("----------");
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
                    System.out.println("----------");
                    System.out.println("Evenement ajoute au MainBard avec succes");
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "msg": {
                if (params.size()==2){
                    try {
                        int idDest = Util.idfrompseudo(mb, params.get(0));
                        Grimpeur dest = mb.getGrimpeurs().get(idDest);
                        Grimpeur env = mb.getGrimpeurs().get(id);
                        Message m = new Message(env, dest, params.get(1));
                        dest.addMessage(m);
                        System.out.println("----------");
                        System.out.println("Message envoyé à " + dest.getPseudo() +" avec succes ");
                    } catch (Error e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
                
            }
            case "ami": {
                if (params.size()== 1) {
                    int idami = Util.idfrompseudo(mb, params.get(0));
                    Grimpeur ami = mb.getGrimpeurs().get(idami); // Le grimpeur dont on veut ajouter l'ami
                    //Grimpeur g = mb.getGrimpeurs().get(id);
                    ami.toggleAmi(g);
                    g.toggleAmi(ami);
                    System.out.println("----------");
                    System.out.println("Amis ajoute avec succes");
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "amis": {
                if (params.size()== 0) {
                    List<Grimpeur> amis = g.getAmis();
                    for (Grimpeur gr : amis) {
                        System.out.println(gr.toString());
                    }
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "rprofil"  : {
                if (params.size()== 1) {
                    String s = params.get(0);
                    List<Grimpeur> result = Util.resProfil(mb, s);
                    for (Grimpeur gr : result ) {
                        System.out.println("----------");
                        System.out.println(gr.toString());
                    }
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
                break;
            }
            case "rvoie" : {
                if (params.size()== 1) { 
                    String s = params.get(0);
                    List<Voie> result = Util.resVoie(mb, s);
                    for (Voie v : result ) {
                        System.out.println("----------");
                        System.out.println(v.toString());
                    }
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                }
            }
            case "stats" : {
                if (params.size()==0) {
                    System.out.println("----------");
                    System.out.println(g.toString());
                    System.out.println("----------");
                    String str="";
                    str += "Nombre de grimpes: " + Integer.toString(g.nbEssais()) + "\n";
                    str += "Nombre de grimpes reussies: " + Integer.toString(g.nbSucces()) + "\n";
                    str += "Derniere voie grimpee: " + g.derniereGrimpe().getNom() + "\n";
                    str += "Niveau grimpe le plus dur: " + Integer.toString(g.plusDureGrimpe()) + "\n";
                    System.out.println(str);
                }
                else if (params.size()==1) {
                    Grimpeur gr = mb.getGrimpeurs().get(Integer.parseInt(params.get(0)));
                    System.out.println("----------");
                    System.out.println(gr.toString());
                    System.out.println("----------");
                    String str="";
                    str += "Nombre de grimpes: " + Integer.toString(gr.nbEssais()) + "\n";
                    str += "Nombre de grimpes reussies: " + Integer.toString(gr.nbSucces()) + "\n";
                    str += "Derniere voie grimpee: " + gr.derniereGrimpe().getNom() + "\n";
                    str += "Niveau grimpe le plus dur: " + Integer.toString(gr.plusDureGrimpe()) + "\n";
                    System.out.println(str);
                } else {
                    System.out.println("----------");
                    System.out.println("Mauvais nombre de parametres");
                } break;
            }
            case "statsv" : {
                if (params.size()==1) {
                    int idVoie = Util.idfromnom(mb, params.get(0));
                    Voie v = mb.getVoies().get(idVoie);
                    System.out.println("----------");
                    System.out.println(v.toString());
                    System.out.println("----------");
                    String str="";
                    str += "Nombre de grimpes: " + Integer.toString(v.nbGrimpes()) + "\n";
                    str += "Taux de reussite: " + Double.toString(v.tauxReussite()) + "\n";
                    str += "score: " + Integer.toString(v.score()) + "\n";
                    str += "score moyen " + Double.toString(v.scoreMoy()) + "\n";
                    System.out.println(str);
                } else {
                    System.out.println("Mauvais nombre d'arguments");
                } break;
            }


// Commandes administrateur
            case "ag" : {
                if (id==0) {
                    if (params.size() == 3 ) {
                        String pseudo = params.get(0);
                        int age = Integer.parseInt(params.get(1));
                        int niveau = Integer.parseInt(params.get(2));
                        Gestionnaire.addGrimpeur(pseudo, age, niveau, mb);
                        System.out.println("----------");
                        System.out.println("Succes");
                    } else {
                        System.out.println("----------");
                        System.out.println("Mauvais nombre de parametres");
                    }
                    
                } else {
                    System.out.println("PERMISSION DENIED !");
                } break;
            }
            case "dg" : {
                if (id==0) {
                    if (params.size() == 1 ) {
                        int idtoremove = Integer.parseInt(params.get(0));
                        Gestionnaire.delGrimpeur(idtoremove, mb);
                        System.out.println("----------");
                        System.out.println("Succes");
                    } else {
                        System.out.println("----------");
                        System.out.println("Mauvais nombre de parametres");
                    }
                } else {
                    System.out.println("PERMISSION DENIED !");
                }
                break;
            }
            case "av" : {
                if (id==0) {
                    if (params.size()==3) {
                        String nom = params.get(0);
                        String secteur = params.get(1);
                        int niveau = Integer.parseInt(params.get(2));
                        Gestionnaire.addVoie(nom, secteur, niveau, mb);
                        System.out.println("----------");
                        System.out.println("Succes");
                    } else {
                        System.out.println("----------");
                        System.out.println("Mauvais nombre de parametres");
                    } 
                } else {
                    System.out.println("PERMISSION DENIED !");
                } break;
            }
            case "dv" : {
                if (id==0) {
                    if (params.size()==1) {
                        int idtoremove = Integer.parseInt(params.get(0));
                        Gestionnaire.delVoie(idtoremove, mb);
                        System.out.println("----------");
                        System.out.println("Succes");
                    } else {
                        System.out.println("----------");
                        System.out.println("Mauvais nombre de parametres");
                    } 
                } else {
                    System.out.println("PERMISSION DENIED !");
                } break;
            }
            case "ov" : {
                if (ouvreur) {
                    if (params.size()==1) {
                        int idVoie = Integer.parseInt(params.get(0));
                        Ouvreur.ouvre(idVoie, mb);
                        System.out.println("----------");
                        System.out.println("Succes");
                    } else {
                        System.out.println("----------");
                        System.out.println("Mauvais nombre de parametres");
                    } 
                } else {
                    System.out.println("PERMISSION DENIED !");
                } break;
            }
            case "fv" : {
                if (ouvreur) {
                    if (params.size()==1) {
                        int idVoie = Integer.parseInt(params.get(0));
                        Ouvreur.ferme(idVoie, mb);
                        System.out.println("----------");
                        System.out.println("Succes");
                    } else {
                        System.out.println("----------");
                        System.out.println("Mauvais nombre de parametres");
                    } 
                } else {
                    System.out.println("PERMISSION DENIED !");
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