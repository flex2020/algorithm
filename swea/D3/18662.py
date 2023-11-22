T = int(input())

for tc in range(1, T + 1):
  answer = 0.0
  x, y, z = map(int, input().split())
  if not (z - y == y - x):
    dx = abs(x - (2 * y - z))
    dy = abs(y - ((x + z) / 2))
    dz = abs(z - (2 * y - x))
    answer = min(dx, dy, dz)

  print(f"#{tc} {answer:.1f}")