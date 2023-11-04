from copy import deepcopy

def getStringSet(str):
    s = []
    for i in range(len(str) - 1):
        if 'A' <= str[i] <= 'Z' and 'A' <= str[i+1] <= 'Z':
            s.append(str[i] + str[i+1])
    return s
def solution(str1, str2):
    answer = 0
    K = 65536
    str1 = str1.upper()
    str2 = str2.upper()
    if str1 == str2:
        return K
    s1 = getStringSet(str1)
    s2 = getStringSet(str2)
    
    inter = 0
    union = 0
    
    # 교집합
    temp = deepcopy(s1)
    while temp:
        x = temp.pop(0)
        if x in s2:
            cnt1 = s1.count(x)
            cnt2 = s2.count(x)
            inter += min(cnt1, cnt2)
            while x in temp:
                temp.remove(x)
    # 합집합
    for i in range(len(s1)):
        if not s1[i] in s2:
            union += 1
    for i in range(len(s2)):
        if not s2[i] in s1:
            union += 1
    temp = deepcopy(s1)
    while temp:
        x = temp.pop(0)
        if x in s2:
            cnt1 = s1.count(x)
            cnt2 = s2.count(x)
            union += max(cnt1, cnt2)
            while x in temp:
                temp.remove(x)
    if inter == 0 and union == 0:
        return 0
    answer = int(inter / union * K)
    return answer