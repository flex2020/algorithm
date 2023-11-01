from collections import deque

T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  deck = list(input().split())
  answer = ''
  q1 = deque()
  q2 = deque()
  mid = N // 2
  if N % 2 == 1:
    mid += 1
  for i in range(mid):
    q1.append(deck[i])
  for i in range(mid, N):
    q2.append(deck[i])
  while q1 or q2:
    if q1:
      answer += q1.popleft() + ' '
    if q2:
      answer += q2.popleft() + ' '
  print(f"#{tc} {answer}")