from collections import deque

def bfs(start_x, start_y):
  q = deque([(start_x, start_y, 0)])
  visited = [[10e9] * C for _ in range(R)]
  visited[start_x][start_y] = 0

  while q:
    # 1분 뒤의 물의 위치를 가져옴
    get_new_graph()
    for _ in range(len(q)):
      x, y, m = q.popleft()
      # 목적지에 도착한 경우 시간을 출력
      if graph[x][y] == 'D':
        print(m)
        return
    
      for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        # 고슴도치가 1분뒤에 갈 수 있다면, 큐에 넣고 방문체크
        if 0 <= nx < R and 0 <= ny < C:
          if graph[nx][ny] != 'X' and graph[nx][ny] != '*' and visited[nx][ny] > m + 1:
            visited[nx][ny] = m + 1
            q.append([nx, ny, m + 1])

  print("KAKTUS")

def get_new_graph():
  water = []
  for i in range(R):
    for j in range(C):
      if graph[i][j] == '*':
        water.append([i, j])
  
  # 각 물의 좌표에서 1분 뒤에 물의 위치를 만듦
  for x, y in water:
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      # 물, 돌, 비버소굴이 아닌 경우 이동함
      if 0 <= nx < R and 0 <= ny < C:
        if graph[nx][ny] == '.':
          graph[nx][ny] = '*'
          
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

R, C = map(int, input().split())

graph = []

for i in range(R):
  graph.append(list(input()))

start_x, start_y = -1, -1

for i in range(R):
  for j in range(C):
    if graph[i][j] == 'S':
      start_x = i
      start_y = j
      graph[i][j] = '.'
bfs(start_x, start_y)