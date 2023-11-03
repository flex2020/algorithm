def dfs(score, kcal, index):
  global answer
  if kcal > L:
    return
  if score > answer:
    answer = score
  if index == N:
    return
  
  dfs(score + food[index][0], kcal + food[index][1], index + 1)
  dfs(score, kcal, index + 1)

T = int(input())

for tc in range(1, T + 1):
  answer = 0
  N, L = map(int, input().split())
  food = []
  for i in range(N):
    a, b = map(int, input().split())
    food.append((a, b))
  dfs(0, 0, 0)

  print(f"#{tc} {answer}")