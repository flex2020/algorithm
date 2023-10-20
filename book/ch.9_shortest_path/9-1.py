## 노드의 개수가 5000개 이하인 경우
## 구현이 간단한 다익스트라 알고리즘
import sys

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

# 방문하지 않은 노드 중에서 최단 거리 노드를 반환
def get_smallest_node():
  min_value = INF
  index = 0
  for i in range(1, N + 1):
    if shorted_path[i] < min_value and not visited[i]:
      min_value = shorted_path[i]
      index = i
  return index

def dijkstra(start):
  # 시작 노드 초기화
  shorted_path[start] = 0
  visited[start] = True
  # 시작 노드와 연결된 모든 노드의 거리를 설정
  for j in graph[start]:
    shorted_path[j[0]] = j[1]
  
  # 시작 노드를 제외한 N-1개의 노드에 대해 반복
  for i in range(N - 1):
    # 현재 최단 거리가 가장 짧은 노드를 꺼내 방문처리
    current = get_smallest_node()
    visited[current] = True

    # 현재 노드와 연결된 다른 노드 확인
    for j in graph[current]:
      # 시작 노드로부터 현재 노드까지의 최단거리 + 다른 노드까지의 거리
      cost = shorted_path[current] + j[1]
      # 최단거리가 갱신되는 경우만 갱신
      if cost < shorted_path[j[0]]:
        shorted_path[j[0]] = cost

dijkstra(start)

for i in range(1, N + 1):
  if shorted_path[i] == INF:
    print(f"{i}까지 도달할 수 없음")
  else:
    print(f"{i}까지의 최단 거리: {shorted_path[i]}")