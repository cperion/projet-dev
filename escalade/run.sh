#!/bin/sh

javac escalade/src/principal/*.java -d bin/principal ;
javac escalade/src/ui/cli/*.java -d bin/ui/cli ;
cd escalade/bin;
java ui.cli.Mainloop;

