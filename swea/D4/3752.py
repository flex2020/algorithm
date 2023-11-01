T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  scores = list(map(int, input().split()))
  max_value = sum(scores)
  visited = [False] * (max_value + 1)
  combination = [0]
  visited[0] = True
  for i in range(N):
    length = len(combination)
    for j in range(length):
      number = combination[j] + scores[i]
      if not visited[number]:
        combination.append(number)
        visited[number] = True
  print(f"#{tc} {len(combination)}")