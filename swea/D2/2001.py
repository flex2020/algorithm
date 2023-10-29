T = int(input())

for t in range(1, T + 1):
  N, M = map(int, input().split())

  graph = []
  for i in range(N):
    graph.append(list(map(int, input().split())))
  answer = 0
  for i in range(N - M + 1):
    for j in range(N - M + 1):
      temp = 0
      for k in range(M):
        temp += sum(graph[i+k][j:j+M])
      answer = max(answer, temp)

  print(f"#{t} {answer}")
      