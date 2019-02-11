import os
import glob

def file_len(fname):
    with open(fname) as f:
        for i, l in enumerate(f):
            pass
    return i + 1

sloc = 0
dir_tree = os.walk('.')

for entry in dir_tree:
    dir_list = list(filter(None, entry[0].split('.')))
    for path in dir_list:
        for file_path in glob.glob('.' + path + '\*.java'):
            length = file_len(file_path)
            print('{} lines in {}'.format(length, file_path))
            sloc += length

print('\n========================')
print('  project SLOC = {}'.format(sloc))
print('========================')
