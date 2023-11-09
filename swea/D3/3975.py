T = int(input())
answer = []
for tc in range(1, T + 1):
  a, b, c, d = map(int, input().split())
  if a / b > c / d: winner = 'ALICE'
  elif a / b < c / d: winner = 'BOB'
  else: winner = 'DRAW'
  answer.append(f"#{tc} {winner}")
for ans in answer:
  print(ans)