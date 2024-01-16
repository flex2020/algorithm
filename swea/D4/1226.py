from collections import deque

def bfs(start_x, start_y):
  global answer
  q = deque([(start_x, start_y)])
  visited = [[False] * 16 for _ in range(16)]
  visited[start_x][start_y] = True

  while q:
    x, y = q.popleft()
    if graph[x][y] == '3':
      answer = 1
      return
    for i in range(4):
      nx, ny = x + dx[i], y + dy[i]
      if 0 <= nx < 16 and 0 <= ny < 16:
        if not visited[nx][ny] and graph[nx][ny] != '1':
          q.append((nx, ny))
          visited[nx][ny] = True

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for _ in range(10):
  answer = 0
  tc = int(input())
  graph = [list(input()) for _ in range(16)]
  for i in range(16):
    for j in range(16):
      if graph[i][j] == '2':
        bfs(i, j)
  print(f"#{tc} {answer}")