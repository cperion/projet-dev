package io;

import principal.*;
import io.Io;
import ui.cli.*;

public class Test {
    public static void main(String[] args) {
        //String fname = "test.mb";
        MainBoard mb = new MainBoard();
        //Io.saveMainBoard(fname, mb);
        //MainBoard mb2 = Io.loadMainBoard(fname);
        //System.out.println(mb2.hi);
        Mainloop.startconsole(mb, 0);
    }
       
}