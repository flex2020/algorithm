N, M = map(int, input().split())

array = []
for i in range(N):
  array.append(int(input()))
INF = 99999999
dp = [INF] * 10001
dp[0] = 0

for i in range(N):
  for j in range(array[i], M + 1):
    if dp[j - array[i]] != INF:
      dp[j] = min(dp[j], dp[j - array[i]] + 1)

if dp[M] == INF:
  print(-1)
else:
  print(dp[M])