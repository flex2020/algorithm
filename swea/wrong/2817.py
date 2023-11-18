T = int(input())

def dfs(s, index, depth):
  global answer
  if s == K:
    answer += 1
    return
  if s > K or depth == N or index == N: return
  dfs(s + numbers[index], index + 1, depth + 1) # index 번째 숫자 사용
  dfs(s, index + 1, depth)
  

for tc in range(1, T + 1):
  answer = 0
  N, K = map(int, input().split())
  numbers = list(map(int, input().split()))
  dfs(0, 0, 0)

  print(f"#{tc} {answer}")