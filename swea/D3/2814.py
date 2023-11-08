def dfs(start, count, visited):
  global answer
  if count > answer:
    answer = count
  for next in graph[start]:
    if not visited[next]:
      visited[next] = True
      dfs(next, count + 1, visited)
      visited[next] = False

T = int(input())

for t in range(1, T + 1):
  N, M = map(int, input().split())
  graph = [[] for _ in range(N)]
  answer = 0
  for i in range(M):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    graph[a].append(b)
    graph[b].append(a)
    
  # 각 노드를 출발점으로 하여 dfs 시작
  for i in range(N):
    visited = [False] * N
    visited[i] = True
    dfs(i, 1, visited)
  print(f"#{t} {answer}")