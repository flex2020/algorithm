T = int(input())
answer = []
for tc in range(1, T + 1):
  N, M = map(int, input().split())
  last = ''
  if M % 2 == 0:
    a = 'OFF'
  else:
    a = 'ON'
    while N:
      if M % 2 == 0:
        a = 'OFF'
        break
      else:
        M //= 2
      N -= 1
  answer.append(f"#{tc} {a}")
for ans in answer:
  print(ans)