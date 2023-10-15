N = int(input())
p = [0]
values = list(map(int, input().split()))
p.extend(values)

dp = [0] * (N + 1)

for i in range(1, N + 1):
  for j in range(1, i + 1):
    dp[i] = max(dp[i], dp[i-j] + p[j])

print(max(dp))