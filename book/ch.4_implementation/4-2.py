N = int(input())

answer = 0

for h in range(0, N+1):
  for m in range(0, 60):
    for s in range(0, 60):
      if '3' in str(h) + str(m) + str(s):
        answer += 1

print(answer)
        