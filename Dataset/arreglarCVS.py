import re
import sys
import csv
from random import randint
print()
ifile = open('newsCorpora.csv', 'r', newline='')
output = open('newsCorpora_edit3.csv', 'w', newline='')
maxInt = sys.maxsize
csv.field_size_limit(maxInt)
dialect = csv.Sniffer().sniff(ifile.read(1024), delimiters="\t")
ifile.seek(0)
read = csv.reader(ifile, dialect)
#read = csv.reader(ifile)
#writer = csv.writer(output)
writer = csv.writer(output, quoting=csv.QUOTE_NONNUMERIC)
#writer = csv.DictWriter(output, delimiter='\t')
for row in read:
    row.append(randint(0, 10000))
    if (len(row) == 9):
         writer.writerow(row)
ifile.close()
output.close()