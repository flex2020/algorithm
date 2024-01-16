T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  answer = 0
  for i in range(1, N+1, 2):
    answer += i
  for i in range(2, N+1, 2):
    answer -= i
  print(f"#{tc} {answer}")