T = int(input())

for tc in range(1, T + 1):
  data = list(map(int, input().split()))
  data.sort()
  answer = round(sum(data[1:len(data)-1]) / (len(data) - 2))

  print(f"#{tc} {answer}")