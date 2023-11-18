T = int(input())
answer = []
for tc in range(1, T + 1):
  a, b, c, d = map(int, input().split())
  ans = max(0, min(b, d) - max(a, c))
  answer.append(f"#{tc} {ans}")
for ans in answer:
  print(ans)