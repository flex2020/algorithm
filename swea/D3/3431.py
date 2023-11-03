T = int(input())

for tc in range(1, T + 1):
  L, U, X = map(int, input().split())
  answer = 0
  if X > U:
    answer = -1
  elif L <= X <= U:
    answer = 0
  else:
    answer = L - X

  print(f"#{tc} {answer}")