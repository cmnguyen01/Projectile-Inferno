'''
    Count source-lines-of-code (SLOC) in project.

    Counts the total number of lines in all .java
    files. This includes white space and comments.
'''

import os
import glob

def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1

def truncate(n, decimals=0):
    multiplier = 10 ** decimals
    return int(n * multiplier) / multiplier

sloc = 0
nfiles = 0
dir_tree = os.walk('.')

for entry in dir_tree:
    dir_list = list(filter(None, entry[0].split('.')))
    for path in dir_list:
        for file_path in glob.glob('.' + path + '\*.java'):
            length = file_len(file_path)
            print('{} lines in {}'.format(length, file_path))
            sloc += length
            nfiles += 1

avg = truncate(sloc/nfiles,1)

print('\n=========== SLOC ===========')
print('  {} lines in {} files'.format(sloc,nfiles))
print('  avg. file: {} lines'.format(avg))
print('============================')
