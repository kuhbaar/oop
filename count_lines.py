#!/usr/bin/python
import os
import commands
import re
import operator

root = "./Gruppe/Aufgabe3/"
authors = {
  'j.schrittwieser@gmail.com': 0, 
  'k.zacky@gmail.com': 0,
  'brummbaerig@gmail.com': 0
  }
total_lines = 0
files_touched_by = {
  'j.schrittwieser@gmail.com': [], 
  'k.zacky@gmail.com': [],
  'brummbaerig@gmail.com': []
  }

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

  for author in involved_authors:
    files_touched_by[author].append(filename)

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


forall_files(root, count_authors)
forall_files(root, count_lines)


for author, lines in sorted(authors.iteritems(), key=operator.itemgetter(1), reverse=True):
  print "%30s: %5d lines - %.2f %%" % (author, lines, 100. * lines / total_lines)

print
for author, files in files_touched_by.iteritems():
  filenames = [(f.split("/")[-1]).split(".")[0] for f in files]
  print "%30s edited %s" % (author, ', '.join(sorted(filenames)))
