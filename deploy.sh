git pull

./test.sh

if [ $? -eq 0 ]; then
  rsync -r Gruppe/ oop:~/Gruppe
else
  echo "won't deploy since tests failed"
fi