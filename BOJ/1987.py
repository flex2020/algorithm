def dfs(x, y, words):
  global answer
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]

    if 0 <= nx < R and 0 <= ny < C:
      if not visited[nx][ny] and not graph[nx][ny] in words:
        visited[nx][ny] = True
        answer = max(answer, len(words) + 1)
        dfs(nx, ny, words + graph[nx][ny])
        visited[nx][ny] = False
      
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
answer = 1
R, C = map(int, input().split())
graph = []
for i in range(R):
  graph.append(input())
visited = [[False] * C for _ in range(R)]
dfs(0, 0, graph[0][0])

print(answer)