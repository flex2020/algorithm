import heapq
S = input()
q = []
number = 0
for s in S:
  if 'A' <= s <= 'Z':
    heapq.heappush(q, s)
  else:
    number += int(s)

for i in range(len(q)):
  print(heapq.heappop(q), end='')
print(number)