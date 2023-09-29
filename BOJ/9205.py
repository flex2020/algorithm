from collections import deque

def bfs():
  q = deque()
  q.append([pos[0][0], pos[0][1]])
  while q:
    x, y = q.popleft()
    distance = abs(x - pos[n+1][0]) + abs(y - pos[n+1][1])
    if distance <= 1000:
      print("happy")
      return
    for i in range(1, n+1):
      if not visited[i]:
        next_x, next_y = pos[i]
        if abs(x - next_x) + abs(y - next_y) <= 1000:
          q.append([next_x, next_y])
          visited[i] = True
  print("sad")
  return


t = int(input())

for i in range(t):
  n = int(input()) # 편의점 수
  pos = []
  for j in range(n+2):
    pos.append(list(map(int, input().split())))
  visited = [False] * (n+1)
  bfs()