def dfs(x, y, direction):
  global answer
  # 현재 칸이 청소되지 않은 경우 현재 칸 청소
  if room[x][y] == 0:
    room[x][y] = 2
    answer += 1
  
  flag = False

  for i in range(0, 4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < N and 0 <= ny < M and room[nx][ny] == 0:
      flag = True
  
  if flag:
    # 반시계 90도 회전
    direction = (direction - 1) % 4
    nx = x + dx[direction]
    ny = y + dy[direction]
    if 0 <= nx < N and 0 <= ny < M and room[nx][ny] == 0:
      dfs(nx, ny, direction)
    else:
      dfs(x, y, direction)
  else:
    nx = x + dx[(direction - 2) % 4]
    ny = y + dy[(direction - 2) % 4]
    if 0 <= nx < N and 0 <= ny < M and room[nx][ny] == 2:
      dfs(nx, ny, direction)
    elif 0 <= nx < N and 0 <= ny < M and room[nx][ny] == 1:
      return

N, M = map(int, input().split())
r, c, d = map(int ,input().split())
answer = 0
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

room = []
for i in range(N):
  room.append(list(map(int, input().split())))
dfs(r, c, d)
print(answer)