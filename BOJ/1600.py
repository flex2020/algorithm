from collections import deque

def bfs():
  q = deque()
  visited = [[[0] * (K+1) for _ in range(W)] for _ in range(H)]
  q.append([0, 0, 0])
  visited[0][0][0] = 1

  while q:
    x, y, k = q.popleft()

    if x == H-1 and y == W-1:
      print(visited[x][y][k] - 1)
      return
    
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < H and 0 <= ny < W and visited[nx][ny][k] == 0 and graph[nx][ny] == 0:
        visited[nx][ny][k] = visited[x][y][k] + 1
        q.append([nx, ny, k])

    if k < K:
      for i in range(4, 12):
        nx = x + dx[i]
        ny = y + dy[i]
        if  0 <= nx < H and 0 <= ny < W and graph[nx][ny] == 0 and visited[nx][ny][k+1] == 0:
          visited[nx][ny][k+1] = visited[x][y][k] + 1
          q.append([nx, ny, k+1])
  print(-1)
dx = [0, 0, -1, 1, -1, -1, 1, 1, -2, -2, 2, 2]
dy = [-1, 1, 0, 0, -2, 2, -2, 2, 1, -1, 1, -1]

K = int(input())
W, H = map(int, input().split())
graph = []
for i in range(H):
  graph.append(list(map(int, input().split())))

bfs()