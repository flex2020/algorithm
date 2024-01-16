T = int(input())

for tc in range(1, T + 1):
  answer = int(1e9)
  N = int(input())
  schedule = list(map(int, input().split()))
  # 일 ~ 토 각각 세봄
  for i in range(7):
    day = 0
    cnt = 0
    ni = i
    while cnt < N:
      if schedule[ni] == 1:
        cnt += 1
      ni = (ni + 1) % 7
      day += 1
    answer = min(day, answer)

  print(f"#{tc} {answer}")