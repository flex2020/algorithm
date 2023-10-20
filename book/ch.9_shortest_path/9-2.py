## 개선된 다익스트라 알고리즘
## heap을 사용

import heapq, sys

input = sys.stdin.readline
INF = int(1e9)

# 노드, 간선의 개수 입력
N, M = map(int, input().split())

# 시작 노드 설정
start = 1

# 인접 리스트 생성
graph = [[] for _ in range(N + 1)]

# 방문체크 리스트 생성
visited = [False] * (N + 1)

# 최단 거리 테이블 초기화
shorted_path = [INF] * (N + 1)

# 간선 정보 입력
for _ in range(M):
  n1, n2, cost = map(int, input().split())
  graph[n1].append((n2, cost))

def dijkstra(start):
  q = []
  # 시작 노드의 최단 경로는 0으로 설정 후 큐에 삽입
  heapq.heappush(q, (0, start))
  shorted_path[start] = 0
  while q:
    dist, current = heapq.heappop(q)
    if shorted_path[current] < dist:
      continue
    
    for i in graph[current]:
      cost = dist + i[1]
      if cost < shorted_path[i[0]]:
        shorted_path[i[0]] = cost
        heapq.heappush(q, (cost, i[0]))

dijkstra(start)

for i in range(1, N + 1):
  if shorted_path[i] == INF:
    print(f"{i}까지 도달할 수 없음")
  else:
    print(f"{i}까지의 최단 거리: {shorted_path[i]}")