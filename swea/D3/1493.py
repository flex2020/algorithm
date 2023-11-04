def setValues():
  start = 1
  d = 1
  for i in range(300):
    graph[i][0] = start
    a = graph[i][0]
    start += d
    d += 1
    for j in range(1, 300):
      graph[i][j] = a + j * (i + 1) + j * (j + 1) // 2
  

def getPosition(value):
  x, y = 0, 0
  for i in range(300):
    if value in graph[i]:
      x = i
      y = graph[i].index(value)
  return (x + 1, y + 1)


T = int(input())

graph = [[0] * 300 for _ in range(300)]
setValues()
for tc in range(1, T + 1):
  p, q = map(int, input().split())

  px, py = getPosition(p)
  qx, qy = getPosition(q)


  answer = graph[px + qx - 1][py + qy - 1]

  print(f"#{tc} {answer}")