N = int(input())

array = [[0,0]]
dp = [0] * (N + 1)

for _ in range(N):
  array.append(list(map(int, input().split())))

for i in range(1, N + 1):
  dp[i] = max(dp[i], dp[i-1])
  ft = array[i][0] + i - 1
  if ft <= N:
    dp[ft] = max(dp[ft], dp[i-1] + array[i][1])

print(max(dp))