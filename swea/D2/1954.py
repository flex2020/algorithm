T = int(input())

def move(x, y):
  global board
  nx, ny = x, y
  n = 1
  d = 0
  while 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 0:
    board[nx][ny] = n
    n += 1
    # 다음 자리가 보드 안이라면
    if 0 <= nx + dx[d] < N and 0 <= ny + dy[d] < N:
      # 보드의 지나가지 않은 부분이라면
      if board[nx + dx[d]][ny + dy[d]] == 0:
        nx += dx[d]
        ny += dy[d]
        continue
    # 방향을 바꿀 상황이라면 방향 바꿔서 전진
    d = (d + 1) % 4
    nx += dx[d]
    ny += dy[d]
    
def display(board):
  for i in range(N):
    for j in range(N):
      print(board[i][j], end=' ')
    print()

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for tc in range(1, T + 1):
  N = int(input())
  board = [[0] * N for _ in range(N)]

  move(0, 0)
  print(f"#{tc}")
  display(board)