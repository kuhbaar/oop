#!/bin/bash
./clean.sh

cd Gruppe/Aufgabe9

# all required files are built recursively
javac -Xlint:all *.java -Werror 

if [ $? -eq 0 ]; then
  java -enableassertions Test
else
  cd ../..
  ./clean.sh
  false
fi
