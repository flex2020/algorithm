## 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야할 때 사용
## 플로이드 워셜 알고리즘
## 시간복잡도: O(N^3) 
INF = 1e9

N = int(input())
M = int(input())

# 인접행렬 초기화
graph = [[INF] * (N + 1) for _ in range(N + 1)]

# 각 노드 스스로까지의 거리는 0
for i in range(1, N + 1):
  graph[i][i] = 0

# 각 간선에 대한 정보를 입력받아 초기화
for _ in range(M):
  # a -> b 의 비용을 c라 설정
  a, b, c = map(int, input().split())
  graph[a][b] = c

# 점화식에 따라 플로이드 워셜 알고리즘 수행
for i in range(1, N + 1):
  for a in range(1, N + 1):
    for b in range(1, N + 1):
      graph[a][b] = min(graph[a][b], graph[a][i] + graph[i][b])

# 결과 출력
for a in range(1, N + 1):
  for b in range(1, N + 1):
    if graph[a][b] == INF:
      print(f"{a} -> {b} 까지 도달 불가")
    else:
      print(f"{a} -> {b} 까지 거리: {graph[a][b]}")