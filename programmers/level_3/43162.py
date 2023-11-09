from collections import Counter
def find_parent(parent, a):
    if parent[a] != a:
        parent[a] = find_parent(parent, parent[a])
    return parent[a]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a > b:
        parent[b] = a
    else:
        parent[a] = b

def solution(n, computers):
    parent = [i for i in range(n)]
    for i in range(n):
        for j in range(n):
            if i != j and computers[i][j] == 1:
                computers[i][j] = 0
                computers[j][i] = 0
                if find_parent(parent, i) != find_parent(parent, j):
                    union_parent(parent, i, j)
    for i in range(n):
        find_parent(parent, i)
    return len(Counter(parent))