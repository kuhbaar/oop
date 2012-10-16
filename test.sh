cd Gruppe/Aufgabe1

rm -f *class
javac -Xlint:all -Werror *java

if [ $? -eq 0 ]; then
  java Test
else
  rm -f *class
  false
fi