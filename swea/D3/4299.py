T = int(input())

for tc in range(1, T + 1):
  answer = 0
  d, h, m = map(int, input().split())
  temp = 11 * 24 * 60 + 11 * 60 + 11
  temp2 = d * 24 * 60 + h * 60 + m
  if temp2 < temp:
    answer = -1
  else:
    answer = temp2 - temp
  print(f"#{tc} {answer}")