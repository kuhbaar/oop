echo -n "Pulling changes from Bitbucket ... "
git pull
echo

./test.sh

if [ $? -eq 0 ]; then
  echo 
  echo -n "cleaning up before pushing to remote server... "
  ./clean.sh
  echo "done!"
  echo -n "pushing ... "
  rsync -r Gruppe/ oop:~/Gruppe
  echo "done!"
else
  echo "won't deploy since tests failed"
fi