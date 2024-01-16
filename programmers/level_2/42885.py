from collections import deque
def solution(people, limit):
    answer = 0
    dq = deque()
    people.sort()
    for p in people: dq.append(p)
    while dq:
        left, right = dq[0], dq[-1]
        new_limit = limit - right
        dq.pop()
        if new_limit >= left and dq:
            dq.popleft()
        answer += 1
    
    return answer