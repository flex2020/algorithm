T = int(input())

for tc in range(1, T + 1):
  answer = 'yes'
  rook = []
  board = [list(input()) for _ in range(8)]
  for i in range(8):
    for j in range(8):
      if board[i][j] == 'O':
        rook.append((i, j))
  if len(rook) != 8: answer = 'no'
  else:
    check = [-1] * 8
    for i in range(8):
      # check[행] = 열 저장 
      r = rook[i]
      if check[r[0]] == -1 and not r[1] in check:
        check[r[0]] = r[1]
      else: 
        answer = 'no'
        break
  print(f"#{tc} {answer}")