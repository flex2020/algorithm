T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  s1 = N * (N + 1) // 2
  s2 = N ** 2
  s3 = 2 * s1

  print(f"#{tc} {s1} {s2} {s3}")