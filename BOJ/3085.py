# x, y 지점에서 사탕을 교환 시 최대가 되는지 확인
def check(x, y):
  global answer
  
  for i in range(2):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < N and 0 <= ny < N:
      if candy[x][y] != candy[nx][ny]:
        candy[x][y], candy[nx][ny] = candy[nx][ny], candy[x][y]
        # 행에서 가장 긴 연속 부분을 찾음
        row = 0
        for i in range(N):
          cnt = 1
          color = ''
          for j in range(N):
            if color == candy[i][j]:
              cnt += 1
            else:
              row = max(row, cnt)
              cnt = 1
              color = candy[i][j]
          row = max(row, cnt)
        # 열에서 가장 긴 연속 부분을 찾음
        col = 0
        for j in range(N):
          cnt = 1
          color = ''
          for i in range(N):
            if color == candy[i][j]:
              cnt += 1
            else:
              col = max(col, cnt)
              cnt = 1
              color = candy[i][j]
          col = max(col, cnt)
        answer = max(answer, row, col)
        candy[x][y], candy[nx][ny] = candy[nx][ny], candy[x][y]
dx = [1, 0]
dy = [0, 1]
N = int(input())
candy = [list(input()) for _ in range(N)]
answer = 0

for i in range(N):
  for j in range(N):
    check(i, j)
print(answer)