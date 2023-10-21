import sys
input = sys.stdin.readline

def jump(x, y):
  global dp
  if x == N-1 and y == N-1:
    return 1
  
  if dp[x][y] != -1:
    return dp[x][y]
  
  # 오른쪽으로 이동
  dp[x][y] = 0
  nx = x
  ny = y + board[x][y]
  if 0 <= ny < N:
    dp[x][y] += jump(nx, ny)
  
  # 아래쪽으로 이동
  nx = x + board[x][y]
  ny = y
  if 0 <= nx < N:
    dp[x][y] += jump(nx, ny)
    
  return dp[x][y]

N = int(input())

board = []
for i in range(N):
  board.append(list(map(int, input().split())))

dp = [[-1] * N for _ in range(N)]

jump(0, 0)

print(dp[0][0])