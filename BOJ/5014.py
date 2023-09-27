from collections import deque

def bfs():
  queue = deque()
  queue.append(S)
  visited[S] = True

  while queue:
    current = queue.popleft()
    if current == G:
      break
    up = current + U
    down = current - D

    if up <= F and not visited[up]:
      queue.append(up)
      building[up] = building[current] + 1
      visited[up] = True
    if down >= 1 and not visited[down]:
      queue.append(down)
      building[down] = building[current] + 1
      visited[down] = True

F, S, G, U, D = map(int, input().split())

# F: 건물의 최대 층
# S: 현재 층
# G: 가야할 층
# U: 위로 가는 층 수
# D: 아래로 가는 층 수

visited = [False] * (F+1)
building = [0] * (F+1)

bfs()
if not visited[G]:
  print("use the stairs")
else:
  print(building[G])