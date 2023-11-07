def find_parent(parent, a):
    if parent[a] != a:
        parent[a] = find_parent(parent, parent[a])
    return parent[a]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def solution(n, wires):
    answer = int(1e9)
    wlen = len(wires)
    for i in range(wlen):
        parent = [i for i in range(n+1)] # 부모노드 초기화
        count = [0] * (n+1) # 각 set의 수를 구함
        for j in range(wlen):
            # i번째 와이어만 연결하지 않음
            if i != j:
                a, b = wires[j]
                if parent[a] != parent[b]:
                    union_parent(parent, a, b)
        for j in range(1, n+1):
            find_parent(parent, j)
        for j in range(1, n+1):
            count[parent[j]] += 1
        cnt1 = max(count)
        count.remove(cnt1)
        cnt2 = max(count)
        diff = abs(cnt1 - cnt2)
        answer = min(answer, diff)
        
    return answer