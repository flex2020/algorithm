def find_max_priority(array):
    max_p = 0
    for i in range(len(array)):
        max_p = max(max_p, array[i][0])
    return max_p
    
def solution(priorities, location):
    answer = 0
    q = []
    plen = len(priorities)
    for i in range(plen):
        p = priorities[i]
        q.append((p, i))
    max_p = find_max_priority(q)
    while q:
        p, l = q.pop(0)
        if p != max_p:
            q.append((p, l))
        else:
            answer += 1
            max_p = find_max_priority(q)
            if l == location:
                break
    
        
    return answer