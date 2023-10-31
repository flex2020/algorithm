T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  stop = [0] * 5001
  for i in range(N):
    a, b = map(int, input().split())
    for j in range(a, b + 1):
      stop[j] += 1
  P = int(input())
  c_list = []
  for i in range(P):
    c_list.append(int(input()))
  
  print(f"#{tc}", end=' ')
  for c in c_list:
    print(stop[c], end=' ')
  print()