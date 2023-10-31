from copy import deepcopy

def n_queen(board, col):
  global answer
  if col == N:
    answer += 1
    return
  for i in range(N):
    # 같은 행에 둘 수 없음
    if not i in board:
        verify = True
        # 이전 열들과 비교해서 대각선으로 잡히지 않는지 확인
        for j in range(col):
          if abs(col - j) == abs(i - board[j]):
            verify = False
            break # 대각선으로 잡힌다면 i열에 놓지 않음
        # 대각선으로 잡히지 않는다면 진행
        if verify:
          board[col] = i # 현재열의 i행에 배치
          n_queen(deepcopy(board), col + 1) # 다음열 진행

T = int(input())

for tc in range(1, T + 1):
  answer = 0
  N = int(input())
  if N == 1:
    answer = 1
  elif N == 2 or N == 3:
    answer = 0
  else:
    for i in range(N):
      board = [-1] * N # 0~N-1 각 열에 놓았던 행번호 저장
      board[0] = i # 첫번째 열에는 i행에 놓음
      n_queen(deepcopy(board), 1)
    



  print(f"#{tc} {answer}")