#!/bin/bash
./clean.sh

cd Gruppe/Aufgabe6

# all required files are built recursively
javac -Xlint:all -Werror *.java

if [ $? -eq 0 ]; then
  java Test
else
  cd ../..
  ./clean.sh
  false
fi
