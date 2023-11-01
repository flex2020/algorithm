def dfs(x, y, visited, depth, number):
  if depth == 7:
    s.add(number)
    return
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < 4 and 0 <= ny < 4:
        dfs(nx, ny, visited, depth + 1, number + board[nx][ny])

T = int(input())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

for tc in range(1, T + 1):
  s = set()
  board = [list(input().split()) for _ in range(4)]

  for i in range(4):
    for j in range(4):
      visited = [[False] * 4 for _ in range(4)]
      # i, j에서 출발
      dfs(i, j, visited, 1, board[i][j])

  answer = len(s)
  print(f"#{tc} {answer}")