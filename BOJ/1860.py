T = int(input())

for test_case in range(1, T + 1):
  answer = 'Possible'
  N, M, K = map(int, input().split())
  schedule = list(map(int, input().split()))
  schedule.sort()

  for i in range(N):
    bread = (schedule[i] // M) * K - (i + 1)
    if bread < 0:
      answer = 'Impossible'
      break

  print(f"#{test_case} {answer}")