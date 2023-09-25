# dp[n] 의 의미: n을 1로 만들기 위한 최소한의 연산 횟수
X = int(input())
dp = [0] * 30001

for i in range(2, X + 1):
  # 현재 수에서 1을 뺀 경우
  dp[i] = dp[i - 1] + 1

  # 현재 수에서 나눗셈 연산을 한 경우
  if i % 5 == 0:
    dp[i] = min(dp[i // 5] + 1, dp[i])
  if i % 3 == 0:
    dp[i] = min(dp[i // 3] + 1, dp[i])
  if i % 2 == 0:
    dp[i] = min(dp[i // 2] + 1, dp[i])

print(dp[X])