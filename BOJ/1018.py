def check(i, j):
  w, b = 0, 0
  for di in range(8):
    for dj in range(8):
      ni, nj = i + di, j + dj
      if board_w[di][dj] != board[ni][nj]:
        w += 1
      if board_b[di][dj] != board[ni][nj]:
        b += 1
  return min(w, b)

N, M = map(int, input().split())

board = [list(input()) for _ in range(N)]

board_w = [
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW'
]
board_b = [
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB',
  'BWBWBWBW',
  'WBWBWBWB'
]

answer = int(1e9)
for i in range(N-7):
  for j in range(M-7):
    answer = min(answer, check(i, j))
  
print(answer)