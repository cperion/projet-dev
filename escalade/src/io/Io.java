package io;

import principal.MainBoard;

public class Io { //SAuvegearde la salle avec tout ce qu'elle contient
    public static void saveMainBoard(String fname, MainBoard mb) {
        mb.save(fname);
    }
}