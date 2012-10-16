./clean.sh

cd Gruppe/Aufgabe1

javac -Xlint:all -Werror *java
javac -Xlint:all -Werror */*java

if [ $? -eq 0 ]; then
  java Test
else
  cd ../..
  ./clean.sh
  false
fi