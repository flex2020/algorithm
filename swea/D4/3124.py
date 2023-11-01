def find_parent(parent, a):
  if parent[a] != a:
    parent[a] = find_parent(parent, parent[a])
  return parent[a]

def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)

  if a <= b:
    parent[b] = a
  else:
    parent[a] = b

T = int(input())

for tc in range(1, T + 1):
  V, E = map(int, input().split())
  answer = 0
  edges = [list(map(int, input().split())) for _ in range(E)]
  edges.sort(key=lambda x:x[2])
  parent = [i for i in range(V + 1)]
  
  for a, b, c in edges:
    if find_parent(parent, a) != find_parent(parent, b):
      union_parent(parent, a, b)
      answer += c

  print(f"#{tc} {answer}")