def f(n):
  n = str(n)
  new_n = 0
  for i in range(len(n)):
    new_n += int(n[i])
  
  return new_n

T = int(input())
answer = []
for tc in range(1, T + 1):
  N = int(input())

  while N >= 10:
    N = f(N)
  answer.append(N)

for tc in range(1, T + 1):
  print(f"#{tc} {answer[tc-1]}")