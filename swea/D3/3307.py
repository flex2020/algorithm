T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  array = list(map(int, input().split()))

  dp = [1] * N

  for i in range(1, N):
    for j in range(i):
      if array[i] >= array[j]:
        dp[i] = max(dp[j] + 1, dp[i])
  print(f"#{tc} {max(dp)}")