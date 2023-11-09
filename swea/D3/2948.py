T = int(input())

for tc in range(1, T + 1):
  N, M = map(int, input().split())
  list1 = list(input().split())
  list2 = list(input().split())
  s = set()
  for i in range(N):
    s.add(list1[i])
  for i in range(M):
    s.add(list2[i])
  answer = N + M - len(s)
  print(f"#{tc} {answer}")