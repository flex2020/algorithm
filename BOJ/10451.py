def dfs(start):
  visited[start] = True

  for i in range(1, N+1):
    if graph[start][i] and not visited[i]:
      return dfs(i)
    elif graph[start][i] and visited[i]:
      return 1

T = int(input())

for i in range(T):
  cycle = 0
  N = int(input())
  visited = [False] * (N+1)
  seq1 = [j for j in range(N+1)]
  seq2 = list(map(int, input().split()))
  

  # 그래프 설정
  graph = [[False] * (N+1) for _ in range(N+1)]
  for j in range(1, N+1):
    start, end = seq1[j], seq2[j-1]
    graph[start][end] = True
  
  # 그래프를 통해 사이클 수 확인
  for i in range(1, N+1):
    if not visited[i]:
      cycle += dfs(i)