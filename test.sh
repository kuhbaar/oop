#!/bin/bash
./clean.sh

cd Gruppe/Aufgabe1

javac -Xlint:all -Werror *.java */*.java

if [ $? -eq 0 ]; then
  java Test
else
  cd ../..
  ./clean.sh
  false
fi