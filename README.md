# rules
- unittests fuer eine klasse immer mindestens von zwei verschiedenen leuten
- jeder commit muss approved werden (code reviews!)

# usage

 - `./test.sh` compiliert die aktuelle Aufgabe und fuert die tests aus
 - mit `./deploy.sh` wird die aktuellste version von bitbucket geholt und dann auf die g0 deployed, aber nur wenn auch die tests funktionieren. Voraussetzung: Eintrag in `.ssh/config` fuer `oop`.