from collections import deque

# 노드의 수와 간선의 수 입력
v, e = map(int, input().split())

# 모든 노드의 진입차수 0
indegree = [0] * (v + 1)

# 그래프를 표현하기 위해 초기화
graph = [[] for _ in range(v + 1)]

# 방향 그래프의 모든 간선 정보 입력
for _ in range(e):
  a, b = map(int, input().split())
  graph[a].append(b)

  # b의 진입차수 1증가
  indegree[b] += 1

# 위상 정렬
def topology_sort():
  result = [] # 수행 결과를 담는 리스트
  q = deque()

  # 처음 시작 시 진입 차수가 0인 노드를 큐에 삽입
  for i in range(1, v + 1):
    if indegree[i] == 0:
      q.append(i)
  
  while q:
    now = q.popleft()
    result.append(now)

    for i in graph[now]:
      indegree[i] -= 1

      if indegree[i] == 0:
        q.append(i)
  print("위상 정렬 결과: ", end='')
  for i in result:
    print(i, end=' ')

topology_sort()