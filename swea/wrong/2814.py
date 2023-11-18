T = int(input())

def dfs(length, visited, node):
  global answer
  if length > answer:
    answer = length
  for next in edges[node]:
    if not visited[next]:
      visited[next] = True
      dfs(length + 1, visited, next)
      visited[next] = False

for tc in range(1, T + 1):
  answer = 1
  N, M = map(int, input().split())
  edges = [[] for _ in range(N)]
  for i in range(M):
    start, end = map(int, input().split())
    start -= 1
    end -= 1
    edges[start].append(end)
    edges[end].append(start)
    # 각 노드에서 출발
  for i in range(N):
    visited = [False] * N
    visited[i] = True
    dfs(1, visited, i)
  
  print(f"#{tc} {answer}")