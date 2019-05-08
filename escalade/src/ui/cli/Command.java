package ui.cli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import principal.MainBoard;

public class Command {
    String command;
    List<String> params;
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
                if (command.length() == 0) {
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
            }
            case "annonce": {
                if (command.length() == 2){
                    String date = params.get(0);
                    String message = params.get(1);
                    mb.addAnonce(date, message, id);
                } else {
                    System.out.println("Mauvais nombre d'arguments pour annonce");
                }

            }
            case "voie": {
                if (command.length() == 1) {
                    
                }
            }
            case "profil": {
                
            }
            case "evenements": {
                
            }
            case "essayee": {
                
            }
            case "preferee": {
                
            }
            case "evenement": {
                
            }
            case "msg": {
                
            }
            case "amis": {
                
            }
        }
        return out;
    }
}