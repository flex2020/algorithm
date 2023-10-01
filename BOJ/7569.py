from collections import deque

def bfs():
  answer = 0
  
  while q:
    answer += 1
    
    for _ in range(len(q)):
      z, x, y = q.popleft()
      for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]

        if 0 <= nx < N and 0 <= ny < M and 0 <= nz < H:
          if graph[nz][nx][ny] == 0:
            graph[nz][nx][ny] = 1
            q.append([nz, nx, ny])
    
  for i in range(H):
    for j in range(N):
      for k in range(M):
        if graph[i][j][k] == 0:
          print(-1)
          return
        
  print(answer - 1)
      
M, N, H = map(int, input().split())
graph = []
dx, dy, dz = [-1, 1, 0, 0, 0, 0], [0, 0, -1, 1, 0, 0], [0, 0, 0, 0, -1, 1]

for i in range(H):
  e = []
  for j in range(N):
    e.append(list(map(int, input().split())))
  graph.append(e)

q = deque()
for i in range(H):
  for j in range(N):
    for k in range(M):
      if graph[i][j][k] == 1:
        q.append([i, j, k])

bfs()