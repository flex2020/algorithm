from collections import deque

def bfs(start_x, start_y):
  q = deque([(start_x, start_y)])
  color = field[start_x][start_y]
  pos = []

  while q:
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < 12 and 0 <= ny < 6:
        if field[nx][ny] == color and not visited[nx][ny]:
          pos.append([nx, ny])
          q.append([nx, ny])
          visited[nx][ny] = True
  if len(pos) >= 4:
    pos.sort(key=lambda x: (x[1], x[0]))
    for i, j in pos:
      field[i][j] = '*'
      bomb_list.append([i, j])
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

field = []
answer = 0

for i in range(12):
  field.append(list(input()))

while True:
  visited = [[False] * 6 for _ in range(12)]
  bomb_list = []

  for i in range(12):
    for j in range(6):
      if field[i][j] != '.' and field[i][j] != '*' and not visited[i][j]:
        bfs(i, j)
  if len(bomb_list) == 0:
    break

  for bomb in bomb_list:
    x, y = bomb
    for i in range(x, 0, -1):
      field[i][y] = field[i-1][y]
    field[0][y] = '.'
  
  answer += 1

print(answer)