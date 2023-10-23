from collections import deque
from copy import deepcopy
N = int(input())

# 각 노드의 입력차수 저장
indegree = [0] * (N + 1)
# 그래프 저장
graph =[[] for i in range(N + 1)]
# 각 노드의 수강 시간 저장
time = [0] * (N + 1)

for i in range(1, N + 1):
  data = list(map(int, input().split()))
  time[i] = data[0]
  for x in data[1:-1]:
    indegree[i] += 1
    graph[x].append(i)

def topology_sort():
  result = deepcopy(time)
  q = deque()

  # 처음 시작 시 입력차수가 0인 노드 삽입
  for i in range(1, N + 1):
    if indegree[i] == 0:
      q.append(i)
  
  while q:
    now = q.popleft()

    for i in graph[now]:
      result[i] = max(result[i], result[now] + time[i])
      indegree[i] -= 1
      if indegree[i] == 0:
        q.append(i)
  for i in range(1, N + 1):
    print(result[i])

topology_sort()

