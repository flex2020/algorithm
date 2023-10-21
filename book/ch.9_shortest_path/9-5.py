import sys, heapq

input = sys.stdin.readline
INF = int(1e9)

N, M, C = map(int, input().split())
graph = [[] for _ in range(N + 1)]
dist = [INF] * (N + 1)

for _ in range(M):
  x, y, z = map(int, input().split())
  graph[x].append((y, z))


def dijkstra(start):
  q = []
  heapq.heappush(q, (0, start))
  dist[start] = 0
  while q:
    d, current = heapq.heappop(q)
    if dist[current] < d:
      continue
    
    for i in graph[current]:
      cost = d + i[1]
      if cost < dist[i[0]]:
        dist[i[0]] = cost
        heapq.heappush(q, (cost, i[0]))
dijkstra(C)

count = 0
max_dist = 0

for d in dist:
  if d != INF:
    count += 1
    max_dist = max(d, max_dist)

print(count - 1, max_dist)