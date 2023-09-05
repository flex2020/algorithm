N, M = map(int, input().split())

answer = 0

for i in range(N):
  data = list(map(int, input().split()))
  min_val = min(data)
  answer = max(min_val, answer)

print(answer)