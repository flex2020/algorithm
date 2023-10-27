def check_increase(number):
  snum = str(number)
  for i in range(len(snum) - 1):
    if snum[i] > snum[i+1]:
      return False
  return True

T = int(input())
for t in range(1, T + 1):
  N = int(input())
  numbers = list(map(int, input().split()))
  answer = -1
  
  for i in range(0, N-1):
    for j in range(i + 1, N):
      mul = numbers[i] * numbers[j]
      if check_increase(mul):
        answer = max(answer, mul)
  print(f"#{t} {answer}")

