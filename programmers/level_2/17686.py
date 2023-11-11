from functools import cmp_to_key

def cmp(a, b):
    a_head, a_number, a_tail = file_split(a)
    b_head, b_number, b_tail = file_split(b)
    
    if a_head.upper() < b_head.upper():
        return -1
    elif a_head.upper() == b_head.upper():
        if int(a_number) < int(b_number):
            return -1
        elif  int(a_number) == int(b_number):
            return 0
        else:
            return 1
    else: 
        return 1

def file_split(a):
    head_flag = False
    number_flag = False
    new_a = ''
    for i in range(len(a)):
        if not head_flag and '0' <= a[i] <= '9':
            new_a += '#'
            head_flag = True
        elif head_flag and not number_flag and not ('0' <= a[i] <= '9'):
            number_flag = True
            new_a += '#'
        new_a += a[i]
    sa = new_a.split('#')
    if len(sa) == 2:
        sa.append('')
    return sa
    
def solution(files):
    files.sort(key=cmp_to_key(cmp))
    return files