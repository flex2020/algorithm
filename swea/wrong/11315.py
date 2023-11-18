T = int(input())

def check(x, y):
  global answer

  for i in range(4):
    nx, ny = x, y
    count = 1
    while count < 5:
      nx += dx[i]
      ny += dy[i]
      if not (0 <= nx < N and 0 <= ny < N): break
      if board[nx][ny] != 'o': break
      count += 1
    if count == 5: answer = "YES"

dx = [-1, 0, 1, 1]
dy = [1, 1, 1, 0]

for tc in range(1, T + 1):
  answer = "NO"
  N = int(input())
  board = [list(input()) for _ in range(N)]
  for i in range(N):
    for j in range(N):
      if answer == "YES": break
      if board[i][j] == 'o':
        check(i, j)

  print(f"#{tc} {answer}")