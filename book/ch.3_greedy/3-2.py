N, M, K = map(int, input().split())

numbers = list(map(int, input().split()))

numbers.sort()

number1 = numbers[N-1]
number2 = numbers[N-2]

answer = 0

for i in range(0, M):
  if ((i + 1) % K) == 0:
    answer += number2
  else:
    answer += number1

print(answer)