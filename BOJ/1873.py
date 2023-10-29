T = int(input())
tanks = ['^', '>', 'v', '<']
for t in range(1, T + 1):
  graph = []
  x, y, d = 0, 0, ''
  H, W = map(int, input().split())
  for i in range(H):
    graph.append(list(input()))
    for j in range(4):
      tank = tanks[j]
      if tank in graph[i]:
        x, y = i, graph[i].index(tank)
        if j == 0:
          d = 'U'
        elif j == 1:
          d = 'R'
        elif j == 2:
          d = 'D'
        elif j == 3:
          d = 'L'

  N = int(input())
  ops = list(input())

  for op in ops:
    # 방향 기록
    if op != 'S':
      d = op
    # 위 이동
    if op == 'U':
      graph[x][y] = '^'
      nx = x - 1
      if 0 <= nx < H and graph[nx][y] == '.':
        graph[nx][y] = '^'
        graph[x][y] = '.'
        x = nx
    # 아래 이동
    elif op == 'D':
      graph[x][y] = 'v'
      nx = x + 1
      if 0 <= nx < H and graph[nx][y] == '.':
        graph[nx][y] = 'v'
        graph[x][y] = '.'
        x = nx
    # 왼쪽 이동
    elif op == 'L':
      graph[x][y] = '<'
      ny = y - 1
      if 0 <= ny < W and graph[x][ny] == '.':
        graph[x][ny] = '<'
        graph[x][y] = '.'
        y = ny
    # 오른쪽 이동
    elif op == 'R':
      graph[x][y] = '>'
      ny = y + 1
      if 0 <= ny < W and graph[x][ny] == '.':
        graph[x][ny] = '>'
        graph[x][y] = '.'
        y = ny
    # 포탄 발사
    elif op == 'S':
      if d == 'U':
        for i in range(x-1, -1, -1):
          if graph[i][y] == '#':
            break
          if graph[i][y] == '*':
            graph[i][y] = '.'
            break
      elif d == 'D':
        for i in range(x+1, H):
          if graph[i][y] == '#':
            break
          if graph[i][y] == '*':
            graph[i][y] = '.'
            break
      elif d == 'R':
        for i in range(y+1, W):
          if graph[x][i] == '#':
            break
          if graph[x][i] == '*':
            graph[x][i] = '.'
            break
      elif d == 'L':
        for i in range(y-1, -1, -1):
          if graph[x][i] == '#':
            break
          if graph[x][i] == '*':
            graph[x][i] = '.'
            break
    
  print(f"#{t}", end=' ')
  for i in range(H):
    for j in range(W):
      print(graph[i][j], end='')
    print()
      


