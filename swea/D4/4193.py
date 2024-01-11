from collections import deque

def bfs(start_x, start_y, end_x, end_y):
  global answer
  q = deque([(start_x, start_y, 0)])
  visited = [[INF] * (N+1) for _ in range(N+1)]
  visited[start_x][start_y] = graph[start_x][start_y]
  
  while q:
    x, y = q.popleft()
    
    if x == end_x and y == end_y:
      answer = min(answer, visited[end_x][end_y])

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < N:
        if visited[x][y] + graph[nx][ny] + 1 < visited[nx][ny]:
          visited[nx][ny] = visited[x][y] + graph[nx][ny] + 1
          q.append((nx, ny))
  
INF = 1e9
dx = [-1, 1, 0, 0]
dy = [0, 0, 1, -1]

T = int(input())
for tc in range(1, T + 1):
  answer = INF
  N = int(input())
  graph = [list(map(int, input().split())) for _ in range(N)]
  start_x, start_y = map(int, input().split())
  end_x, end_y = map(int, input().split())
  bfs(start_x, start_y, end_x, end_y)

  print(f"#{tc} {answer}")