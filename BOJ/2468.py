def dfs(x, y, h):
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]

    if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and array[nx][ny] > h:
      visited[nx][ny] = True
      dfs(nx, ny, h)

import sys

sys.setrecursionlimit(100000)

N = int(input())
max_height = 0
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

answer = 1

array = []
for i in range(N):
  array.append(list(map(int, input().split())))
  max_height = max(max_height, max(array[i]))

for i in range(1, max_height):
  cnt = 0
  visited = [[False] * (N) for _ in range(N)]

  for j in range(N):
    for k in range(N):
      if array[j][k] > i and not visited[j][k]:
        cnt += 1
        visited[j][k] = True
        dfs(j, k, i)
  answer = max(cnt, answer)

print(answer)