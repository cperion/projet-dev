#!/bin/sh

javac escalade/src/principal/*.java -d bin/principal ;
javac escalade/src/ui/cli/*.java -d bin/ui/cli ;
java escalade/bin/ui/cli/Mainloop.class;

