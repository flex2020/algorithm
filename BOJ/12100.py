import copy

def solve(depth, board):
  global answer
  max_number = 0

  for i in range(N):
    for j in range(N):
      max_number = max(max_number, board[i][j])
  answer = max(answer, max_number)

  # 5번 반복했을 때 종료
  if depth == 5:
    return
  
  # 깊이가 5이하인 경우 백트래킹
  dir = ['L', 'R', 'U', 'D']
  for d in dir:
    # 각 방향으로 보드를 이동 후 보드를 얻음
    new_board = move(d, board)
    # 다음 단계 진행
    solve(depth + 1, new_board)

def move(d, board):
  new_board = copy.deepcopy(board)
  pull_board(new_board, d)
  if d == 'L':
    for i in range(N):
      for j in range(N-1):
        # 같은 숫자 두개면
        if new_board[i][j] == new_board[i][j+1]:
          new_board[i][j] = new_board[i][j] * 2
          new_board[i][j+1] = 0
  elif d == 'R':
    for i in range(N):
      for j in range(N-1, 0, -1):
        # 같은 숫자 두개면
        if new_board[i][j] == new_board[i][j-1]:
          new_board[i][j] = new_board[i][j] * 2
          new_board[i][j-1] = 0
  elif d == 'U':
    for j in range(N):
      for i in range(N-1):
        if new_board[i][j] == new_board[i+1][j]:
          new_board[i][j] = new_board[i][j] * 2
          new_board[i+1][j] = 0
  elif d == 'D':
    for j in range(N):
      for i in range(N-1, 0, -1):
        if new_board[i][j] == new_board[i-1][j]:
          new_board[i][j] = new_board[i][j] * 2
          new_board[i-1][j] = 0

  pull_board(new_board, d)
  return new_board

def check_board(board, new_board):
  for i in range(N):
    for j in range(N):
      if board[i][j] != new_board[i][j]:
        return True
  return False

def pull_board(new_board, d):
  if d == 'L':  
    for i in range(N):
      for j in range(N-1, 0, -1):
        if new_board[i][j] != 0 and new_board[i][j-1] == 0:
          new_board[i][j], new_board[i][j-1] = new_board[i][j-1], new_board[i][j]
  elif d == 'R':
    for i in range(N):
      for j in range(N-1):
        if new_board[i][j] != 0 and new_board[i][j+1] == 0:
          new_board[i][j], new_board[i][j+1] = new_board[i][j+1], new_board[i][j]
  elif d == 'U':
    for j in range(N):
      for i in range(N-1, 0, -1):
        if new_board[i][j] != 0 and new_board[i-1][j] == 0:
          new_board[i][j], new_board[i-1][j] = new_board[i-1][j], new_board[i][j]
  elif d == 'D':
    for j in range(N):
      for i in range(N-1):
        if new_board[i][j] != 0 and new_board[i+1][j] == 0:
          new_board[i][j], new_board[i+1][j] = new_board[i+1][j], new_board[i][j]
def display(board):
  print("===============================")
  for i in range(N):
    for j in range(N):
      print(board[i][j], end = ' ')
    print()

N = int(input())
input_board = []
for i in range(N):
  input_board.append(list(map(int, input().split())))
answer = 0

# board = move('R', input_board)

# for _ in range(3):
#   board = move('R', board)

# board = move('U', board)

solve(0, input_board)

print(answer)