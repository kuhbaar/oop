#!/usr/bin/python
import os
import commands
import re
import operator

root = "./Gruppe/Aufgabe3/"
authors = {}
files_touched_by = {}
total_lines = 0
authors_per_file = {}
files_owned_by = {}

for mail in ['j.schrittwieser@gmail.com', 'k.zacky@gmail.com', 'brummbaerig@gmail.com']:
  authors[mail] = 0
  files_touched_by[mail] = []
  files_owned_by[mail] = []

def count_authors(filename):
  involved_authors = {}
  out = commands.getoutput("git blame -e -w -C -C %s" % filename)
  for line in out.split("\n"):
    try:
      author = re.findall("""<([^>]+)""", line)[0].lower()
      involved_authors[author] = True
      authors[author] += 1
    except:
      print line

  authors_per_file[filename] = []
  for author in involved_authors:
    files_touched_by[author].append(filename)
    authors_per_file[filename].append(author)
  

def count_lines(filename):
  global total_lines
  f = open(filename)
  for line in f:
    total_lines += 1
  f.close()


def forall_files(dirname, fun):
  for root, dirs, files in os.walk(dirname):
    for f in files:
      filename = "%s/%s" % (root, f)
      fun(filename)

def clean_filename(name):
  return (name.split("/")[-1]).split(".")[0]

forall_files(root, count_authors)
forall_files(root, count_lines)


for file, auths in authors_per_file.iteritems():
  if len(auths) == 1:
    files_owned_by[auths[0]].append(clean_filename(file))


for author, lines in sorted(authors.iteritems(), key=operator.itemgetter(1), reverse=True):
  print "%30s: %5d lines - %.2f %%" % (author, lines, 100. * lines / total_lines)

print
for author, files in files_touched_by.iteritems():
  filenames = [clean_filename(f) for f in files]
  print "%30s edited %s" % (author, ', '.join(sorted(filenames)))

print
for author, files in files_owned_by.iteritems():
  filenames = [clean_filename(f) for f in files]
  print "%30s owns %s" % (author, ', '.join(sorted(filenames)))

	

