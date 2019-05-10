#!/bin/sh

javac escalade/src/principal/*.java -d escalade/bin/principal ;
javac escalade/src/ui/cli/*.java -d escalade/bin/ui/cli ;
cd escalade/bin;
java ui.cli.Mainloop;

