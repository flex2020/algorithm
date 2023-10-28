from collections import deque

def bfs(start_x, start_y):
  global answer
  q = deque([(start_x, start_y)])
  visited[start_x][start_y] = True
  
  while q:
    x, y = q.popleft()
    if x == 0:
      answer = y
      return
    # 왼쪽, 오른쪽 먼저 살핌
    ny = y - 1
    if 0 <= ny < 100 and graph[x][ny] == 1 and not visited[x][ny]:
      q.append((x, ny))
      visited[x][ny] = True
      continue
    ny = y + 1
    if 0 <= ny < 100 and graph[x][ny] == 1 and not visited[x][ny]:
      q.append((x, ny))
      visited[x][ny] = True
      continue
    # 왼쪽, 오른쪽 중 갈 곳이 없다면 위로 올라감
    nx = x - 1
    if 0 <= nx < 100 and graph[nx][y] == 1 and not visited[nx][y]:
      q.append((nx, y))
      visited[nx][y] = True


T = 1
for _ in range(1, T + 1):
  t = int(input())
  answer = 0
  graph = []
  for _ in range(100):
    graph.append(list(map(int, input().split())))
  
  x, y = 99, graph[99].index(2)
  visited = [[False] * 100 for _ in range(100)]
  bfs(x, y)
  print(f"#{t} {answer}")
