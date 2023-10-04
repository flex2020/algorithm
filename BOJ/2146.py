from collections import deque

# 각 육지별로 숫자를 다르게 설정
def set_graph(start_x, start_y, number):
  q = deque()
  q.append([start_x, start_y])
  graph[start_x][start_y] = number
  
  while q:
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < N:
        if input_list[nx][ny] == 1 and graph[nx][ny] == 0:
          q.append([nx, ny])
          graph[nx][ny] = number

def bfs(start_x, start_y, number):
  global answer
  q = deque()
  q.append([start_x, start_y, 0])
  visited[start_x][start_y] = True

  while q:
    x, y, d = q.popleft()
    # 이미 거리가 현재 최솟값을 넘어선 경우는 제외
    if (d > answer):
      continue
    
    for i in range(4):
      nx, ny = x + dx[i], y + dy[i]
      
      if 0 <= nx < N and 0 <= ny < N:
        if graph[nx][ny] == 0 and not visited[nx][ny]:
          q.append([nx, ny, d+1])
          visited[nx][ny] = True
        elif graph[nx][ny] > 0 and graph[nx][ny] != number:
          answer = min(answer, d)
          



dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N = int(input())
input_list = []
for i in range(N):
  input_list.append(list(map(int, input().split())))

answer = 10e9
graph = [[0] * N for _ in range(N)]
cnt = 1
# 각 섬에 번호 부여
for i in range(N):
  for j in range(N):
    if input_list[i][j] == 1 and graph[i][j] == 0:
      set_graph(i, j, cnt)
      cnt += 1

# 모든 좌표를 돌면서 다리를 놓아 최솟값을 구한다
for i in range(N):
  for j in range(N):
    if graph[i][j] >= 1:
      # 현재 위치가 섬이라면 다른 섬까지의 다리의 최솟값을 구한다.
      visited = [[False] * N for _ in range(N)]
      bfs(i, j, graph[i][j])

print(answer)