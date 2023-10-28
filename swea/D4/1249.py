from collections import deque

def bfs():
  q = deque([(0, 0)])
  visited[0][0] = graph[0][0]

  while q:
    x, y = q.popleft()
    if x == N-1 and y == N-1:
      continue

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < N:
        if visited[nx][ny] > visited[x][y] + graph[x][y]:
          q.append((nx, ny))
          visited[nx][ny] = visited[x][y] + graph[x][y]

T = int(input())
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
INF = int(1e9)
for t in range(1, T + 1):
  N = int(input())
  visited = [[INF] * N for _ in range(N)]
  graph = []
  for i in range(N):
    graph.append(list(map(int, input())))

  bfs()
  
  print(f"#{t} {visited[N-1][N-1]}")