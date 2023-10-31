def dfs(x, y, direction, count, visited):
  global answer
  nx = x + dx[direction]
  ny = y + dy[direction]
  if 0 <= nx < N and 0 <= ny < N:
    if board[nx][ny] == 'o':
      # 같은 방향 앞에 돌이 있다면 그 돌로 이동
      count += 1
      visited[nx][ny] = True
      # 오목이 아직 안됐다면 다음꺼 탐색
      if count < 5:
        dfs(nx, ny, direction, count, visited)
      # 오목이 됐다면 답 바꾸고 종료
      else:
        answer = 'YES'
        return

dx = [1, -1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]

T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  answer = 'NO'
  board = []
  for i in range(N):
    board.append(list(input()))
  
  for i in range(N):
    for j in range(N):
      if board[i][j] == 'o':
        for k in range(8):
          visited = [[False] * N for _ in range(N)]
          visited[i][j] = True
          dfs(i, j, k, 1, visited)

  print(f"#{tc} {answer}")