from collections import deque

def bfs(start_x, start_y):
  q = deque()
  q.append([start_x, start_y])
  visited[start_x][start_y] = True

  while q:
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < M:
        if array[nx][ny] == 0:
          cnt[x][y] += 1
        elif not visited[nx][ny]:
          q.append([nx, ny])
          visited[nx][ny] = True

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

N, M = map(int ,input().split())
array = []
for i in range(N):
  array.append(list(map(int, input().split())))

answer = 0
while True:
  visited = [[False] * M for _ in range(N)]
  cnt = [[0] * M for _ in range(N)]
  group = 0
  for i in range(N):
    for j in range(M):
      if array[i][j] != 0 and not visited[i][j]:
        bfs(i, j)
        group += 1
  for i in range(N):
    for j in range(M):
      array[i][j] -= cnt[i][j]
      array[i][j] = max(0, array[i][j])

  if group == 0 or group >= 2:
    break
  answer += 1
  

if group < 2:
  print(0)
else:
  print(answer)
