from collections import deque
def init_board():
  board = [[0] * N for _ in range(N)]
  q = deque([2, 1, 1, 2])
  start = 0
  if N == 4:
    start = 1
  elif N == 6:
    start = 2
  elif N == 8:
    start = 3
  for i in range(start, start+2):
    for j in range(start, start+2):
      board[i][j] = q.popleft()
  return board

def find_change_position(nx, ny, target_color, direction):
  expected = []
  change_flag = False
  while True:
    nx += dx[direction]
    ny += dy[direction]
    # 보드 범위 내인지 확인하고
    if 0 <= nx < N and 0 <= ny < N:
      # 목표로 하는 색깔인지 확인
      if board[nx][ny] == target_color:
        expected.append((nx, ny))
      # 바뀔 조건이 갖춰지면 종료
      elif len(expected) > 0 and board[nx][ny] == target[target_color]:
        change_flag = True
        break
      else:
        break
    # 범위 밖이면 종료
    else:
      break
  if change_flag:
    return expected
  else:
    return []
        
def display(board):
  for i in range(N):
    for j in range(N):
      print(board[i][j], end=' ')
    print()

T = int(input())

dx = [1, -1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]

for tc in range(1, T + 1):
  # 바둑판 크기와 놓는 횟수 입력
  N, M = map(int, input().split())
  black, white = 0, 0 
  target = [0, 2, 1]
  # board 초기 세팅
  board = init_board()
  
  # 바둑돌을 놓음
  for i in range(M):
    y, x, current_color = map(int, input().split())
    x, y = x - 1, y - 1 # 배열 범위에 맞게 줄임
    board[x][y] = current_color # 바둑돌 배치
    target_color = target[current_color] # 바꿀 색 고름    

    # 돌을 놓은 후 각 방향으로 색이 바뀔 수 있는 자리를 찾음
    change = []
    for j in range(8):
      data = find_change_position(x, y, target_color, j) # 바뀔 수 있는 곳의 좌표만 불러옴
      for d in data:
        if not d in change:
          change.append(d)
    
    # 바꿀 자리를 전부 변경
    for a, b in change:
      board[a][b] = current_color

  for i in range(N):
    for j in range(N):
      if board[i][j] == 1:
        black += 1
      elif board[i][j] == 2:
        white += 1

  print(f"#{tc} {black} {white}")

