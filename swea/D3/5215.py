def dfs(index, score, kcal):
  global answer
  # 칼로리 초과 혹은 index 초과
  if kcal > L:
    return
  # 음식 점수 갱신
  if score > answer:
    answer = score
  if index == N:
    return
  # index번째 재료를 사용한 경우
  dfs(index + 1, score + data[index][0], kcal + data[index][1])
  # index번째 재료를 사용하지 않은 경우
  dfs(index + 1, score, kcal)

T = int(input())

for test_case in range(1, T + 1):
  N, L = map(int, input().split())
  data = []
  for _ in range(N):
    t, k = map(int, input().split())
    data.append((t, k))
  answer = 0
  dfs(0, 0, 0)
  
  print(f"#{test_case} {answer}")