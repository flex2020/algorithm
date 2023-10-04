from collections import deque

def bfs():
  q = deque()
  q.append([0, 0, 0])
  visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]
  visited[0][0][0] = 1
  while q:
    x, y, z = q.popleft()
    if x == N-1 and y == M-1:
      print(visited[x][y][z])
      return
    
    # 그냥 갈 수 있는지 확인
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < M:
        if graph[nx][ny] == 0 and visited[nx][ny][z] == 0:
          q.append([nx, ny, z])
          visited[nx][ny][z] = visited[x][y][z] + 1
        # 다음 경로가 벽이고, 아직 벽을 한번도 부수지 않은 경우
        elif graph[nx][ny] == 1 and z == 0:
          q.append([nx, ny, 1])
          visited[nx][ny][1] = visited[x][y][0] + 1
          
    
    

  print(-1)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


N, M = map(int, input().split())
graph = []
for i in range(N):
  graph.append(list(map(int, input())))

bfs()