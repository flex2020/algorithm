T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  temp = int(N ** (1/3))
  answer = -1
  for i in range(temp - 1, temp + 2):
    if i ** 3 == N:
      answer = i
      break
  
  print(f"#{tc} {answer}")