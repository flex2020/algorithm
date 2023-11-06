N = int(input())
answer = int(1e9)

# 5원을 i개 사용
for i in range(N//5 + 1):
  temp = N
  temp -= 5 * i
  if temp % 2 == 0:
    answer = min(answer, i + temp // 2)

if answer == int(1e9):
  print(-1)
else:
  print(answer)