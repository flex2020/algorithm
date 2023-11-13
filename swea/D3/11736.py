T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  numbers = list(map(int, input().split()))
  answer = 0
  for i in range(1, N - 1):
    a, b, c = numbers[i-1:i+2]
    if a < b < c or c < b < a:
      answer += 1

  print(f"#{tc} {answer}")