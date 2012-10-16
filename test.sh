cd Gruppe/Aufgabe1
javac -Xlint:unchecked  *java

if [ $? -eq 0 ]; then
  java Test
else
  false
fi