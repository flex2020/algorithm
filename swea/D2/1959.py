T = int(input())

for t in range(1, T + 1):
  N, M = map(int, input().split())
  answer = int(-1e9)
  a = list(map(int, input().split()))
  b = list(map(int, input().split()))

  if N <= M:
    for i in range(M - N + 1):
      temp = 0
      for j in range(N):
        temp += a[j] * b[i+j]
      answer = max(answer, temp)
  else:
    for i in range(N - M + 1):
      temp = 0
      for j in range(M):
        temp += b[j] * a[i+j]
      answer = max(answer, temp)
  print(f"#{t} {answer}")