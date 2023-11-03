T = int(input())

for tc in range(1, T + 1):
  t = int(input())
  scores = [0] * 101
  data = list(map(int, input().split()))
  for s in data:
    scores[s] += 1
  answer = 0
  max_cnt = 0
  for i in range(101):
    if scores[i] >= max_cnt:
      max_cnt = scores[i]
      answer = i
  print(f"#{tc} {answer}")