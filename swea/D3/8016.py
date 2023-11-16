T = int(input())

for tc in range(1, T + 1):
  F = int(input())
  if F == 1:
    left, right = 1, 1
  else:
    temp = F * (F - 1)
    left = temp - (F - 1) + 1
    right = temp + F
    left = 2 * left - 1
    right = 2 * right - 1
  
  print(f"#{tc} {left} {right}")
  