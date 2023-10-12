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
    new_board = move(d, copy.deepcopy(board))
    # 다음 단계 진행
    solve(depth + 1, new_board)

def move(d, board):
  if d == 'L':
    for i in range(N):
      top = 0
      for j in range(1, N):
        if board[i][j]:
          tmp = board[i][j]
          board[i][j] = 0
          if board[i][top] == 0:
            board[i][top] = tmp
          elif board[i][top] == tmp:
            board[i][top] = tmp * 2
            top += 1
          else:
            top += 1
            board[i][top] = tmp
  elif d == 'R':
    for i in range(N):
      top = N - 1
      for j in range(N - 2, -1, -1):
        if board[i][j]:
          tmp = board[i][j]
          board[i][j] = 0
          if board[i][top] == 0:
            board[i][top] = tmp
          elif board[i][top] == tmp:
            board[i][top] = tmp * 2
            top -= 1
          else:
            top -= 1
            board[i][top] = tmp
  elif d == 'U':
    for j in range(N):
      top = 0
      for i in range(N):
        if board[i][j]:
          tmp = board[i][j]
          board[i][j] = 0
          if board[top][j] == 0:
            board[top][j] = tmp
          elif board[top][j] == tmp:
            board[top][j] = tmp * 2
            top += 1
          else:
            top += 1
            board[top][j] = tmp
  elif d == 'D':
    for j in range(N):
      top = N - 1
      for i in range(N-2, -1, -1):
        if board[i][j]:
          tmp = board[i][j]
          board[i][j] = 0
          if board[top][j] == 0:
            board[top][j] = tmp
          elif board[top][j] == tmp:
            board[top][j] = tmp * 2
            top -= 1
          else:
            top -= 1
            board[top][j] = tmp
  return board


N = int(input())
input_board = []
for i in range(N):
  input_board.append(list(map(int, input().split())))
answer = 0

solve(0, input_board)

print(answer)