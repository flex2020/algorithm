def pow2(a, n):
  if n == 0:
    return 1
  return a * pow2(a, n-1)

for _ in range(1, 11):
  tc = int(input())
  a, n = map(int, input().split())
  print(f"#{tc} {pow2(a, n)}")