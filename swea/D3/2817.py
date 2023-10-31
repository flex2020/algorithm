def dfs(index, visited, sum):
  global answer
  if sum == K:
    answer += 1
    return
  
  for i in range(index+1, N):
    if not visited[i] and sum + A[i] <= K:
      visited[i] = True
      dfs(i, visited, sum + A[i])
      visited[i] = False

T = int(input())

for tc in range(1, T + 1):
  N, K = map(int, input().split())
  A = list(map(int, input().split()))
  answer = 0
  A.sort()

  for i in range(0, N):
    visited = [False] * N
    visited[i] = True
    dfs(i, visited, A[i])


  print(f"#{tc} {answer}")