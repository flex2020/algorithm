N, M = map(int, input().split())

frame = []
answer = 0

for i in range(N):
  frame.append(list(map(int, input())))

def dfs(x, y):
  # 범위를 벗어나면 종료
  if x < 0 or x >= N or y < 0 or y >= M:
    return False
  
  if frame[x][y] == 0:
    frame[x][y] = 1
    dfs(x-1, y)
    dfs(x, y-1)
    dfs(x+1, y)
    dfs(x, y+1)
    return True
  return False

for i in range(N):
  for j in range(M):
    if dfs(i, j) == True:
      answer += 1

print(answer)
