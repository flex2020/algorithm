from collections import deque

for _ in range(10):
  tc = int(input())
  answer = ''
  temp_list = list(map(int, input().split()))
  dq = deque()
  for i in range(8): dq.append(temp_list[i])
  i = 1
  while dq[-1] != 0:
    head = dq.popleft()
    tail = max(0, head - i)
    dq.append(tail)
    i += 1
    if i == 6: i = 1
  while dq:
    answer += str(dq.popleft()) + ' '
  print(f"#{tc} {answer}")