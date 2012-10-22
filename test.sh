#!/bin/bash
./clean.sh

cd Gruppe/Aufgabe2

# all required files are built recursively
javac -Xlint:all -Werror *.java */*.java */*/*.java

if [ $? -eq 0 ]; then
  java Test
else
  cd ../..
  ./clean.sh
  false
fi