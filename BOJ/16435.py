N, L = map(int, input().split())
fruit = list(map(int, input().split()))
fruit.sort()
for f in fruit:
  if f <= L:
    L += 1
  else: break

print(L)