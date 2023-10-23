import sys

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

input = sys.stdin.readline

N, M = map(int, input().split())

parent = [0] * (N + 1)

for i in range(N):
  parent[i] = i

edges = []
for _ in range(M):
  a, b, c = map(int, input().split())
  edges.append((c, a, b))
edges.sort()
result = 0
for edge in edges:
  cost, a, b = edge
  
  if find_parent(parent, a) != find_parent(parent, b):
    union_parent(parent, a, b)
    result += cost
    last = cost
print(result - last)

