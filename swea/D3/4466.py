T = int(input())

for tc in range(1, T + 1):
  N, K = map(int, input().split())
  score = list(map(int, input().split()))
  score.sort(reverse=True)
  answer = sum(score[:K])

  print(f"#{tc} {answer}")