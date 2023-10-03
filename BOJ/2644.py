def dfs(start, target, depth):
  # 목적지 도착했다면 종료
  if start == target:
    global answer
    answer = depth
    return

  # 현재 노드 방문처리
  visited[start] = True

  # 만약 아직 탐색할 곳이 있다면 탐색
  for i in range(1, n+1):
    if graph[start][i] == 1 and not visited[i]:
      dfs(i, target, depth + 1)

n = int(input())
target1, target2 = map(int, input().split())

graph = [[-1] * (n+1) for _ in range(n+1)]
visited = [False] * (n + 1)

m = int(input())
for i in range(m):
  p, c = map(int, input().split())
  graph[p][c] = 1
  graph[c][p] = 1

answer = -1
dfs(target1, target2, 0)
print(answer)
