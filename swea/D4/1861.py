from collections import deque

def bfs(start_x, start_y):
  global answer, start_number
  q = deque([(start_x, start_y, graph[start_x][start_y])])

  while q:
    x, y, start = q.popleft()
    if answer < visited[x][y]:
      answer = visited[x][y]
      start_number = start
    elif answer == visited[x][y]:
      start_number = min(start_number, start)
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < N:
        if visited[nx][ny] <= visited[x][y] + 1 and graph[nx][ny] == graph[x][y] + 1:
          visited[nx][ny] = visited[x][y] + 1
          q.append((nx, ny, start))
  

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

T = int(input())

for tc in range(1, T + 1):
  answer = 0
  start_number = int(1e9)
  N = int(input())
  graph = [list(map(int, input().split())) for _ in range(N)]
  visited = [[1] * N for _ in range(N)]
  for i in range(N):
    for j in range(N):
        bfs(i, j)

  print(f"#{tc} {start_number} {answer}")