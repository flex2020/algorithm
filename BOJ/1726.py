from collections import deque

def bfs():
  q = deque([(start_x - 1, start_y - 1, start_dir - 1, 0)])
  visited = [[[False] * 4 for _ in range(M)] for _ in range(N)]
  visited[start_x - 1][start_y - 1][start_dir - 1] = 0
  while q:
    x, y, d, cnt = q.popleft()

    # 도착 했다면 종료
    if x == dest_x - 1 and y == dest_y - 1 and d == dest_dir - 1:
      print(cnt)
      return
    
    for i in range(1, 4):
      nx = x + dx[d] * i
      ny = y + dy[d] * i

      if nx < 0 or nx >= N or ny < 0 or ny >= M or visited[nx][ny][d]:
        continue
      if graph[nx][ny] == 1:
        break
      
      visited[nx][ny][d] = True
      q.append([nx, ny, d, cnt + 1])
    # 현재 방향이 동, 서인 경우
    if d == 0 or d == 1:
      # 남쪽 체크
      if not visited[x][y][2]:
        visited[x][y][2] = True
        q.append([x, y, 2, cnt + 1])
      # 북쪽 체크
      if not visited[x][y][3]:
        visited[x][y][3] = True
        q.append([x, y, 3, cnt + 1])
    # 현재 방향이 남, 북인 경우
    else:
      # 동쪽 체크
      if not visited[x][y][0]:
        visited[x][y][0] = True
        q.append([x, y, 0, cnt + 1])
      # 서쪽 체크
      if not visited[x][y][1]:
        visited[x][y][1] = True
        q.append([x, y, 1, cnt + 1])

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

N, M = map(int, input().split())
graph = []
for i in range(N):
  graph.append(list(map(int, input().split())))
start_x, start_y, start_dir = map(int, input().split())
dest_x, dest_y, dest_dir = map(int, input().split())

bfs()