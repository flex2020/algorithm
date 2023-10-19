import heapq, sys
input = sys.stdin.readline

N = int(input())
heap = []
for i in range(N):
  x = int(input())
  if x == 0:
    if len(heap) > 0:
      answer = -heapq.heappop(heap)
      print(answer)
    else:
      print(0)
  else:
    heapq.heappush(heap, -x)
