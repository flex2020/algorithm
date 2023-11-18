T = int(input())

for tc in range(1, T + 1):
  N, K = map(int, input().split())
  things = [list(map(int, input().split())) for _ in range(N)]
  dp = [[0] * (K + 1) for _ in range(N + 1)] # dp[i][j] == i번째까지 물건을 넣고, 부피가 j 일때 가치의 최댓값
  for i in range(1, N + 1):
    for j in range(1, K + 1):
      # 물건을 더 넣을 수 없는 경우
      if things[i-1][0] > j:
        dp[i][j] = dp[i-1][j]
      else:
        v = j - things[i-1][0]
        dp[i][j] = max(dp[i-1][v] + things[i-1][1], dp[i-1][j])
  print(f"#{tc} {dp[N][K]}")