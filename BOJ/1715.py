import sys, heapq

input = sys.stdin.readline

N = int(input())

cards = []

for i in range(N):
  heapq.heappush(cards, int(input()))

if len(cards) == 1:
  print(0)
else:
  answer = 0
  while len(cards) > 1:
    d1 = heapq.heappop(cards)
    d2 = heapq.heappop(cards)
    answer += d1 + d2
    heapq.heappush(cards, d1 + d2)
  print(answer)