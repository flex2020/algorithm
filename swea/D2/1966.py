T = int(input())

for tc in range(1, T + 1):
  answer = ''
  N = int(input())
  numbers = list(map(int, input().split()))
  numbers.sort()
  for n in numbers: answer += str(n) + ' '
  
  print(f"#{tc} {answer}")