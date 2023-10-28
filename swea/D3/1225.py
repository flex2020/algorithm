for _ in range(1, 11):
  t = int(input())
  numbers = list(map(int, input().split()))
  a = 1
  while True:
    numbers[0] -= a
    a += 1
    temp = numbers[0]
    # 숫자 앞으로 당기기
    numbers[0:7] = numbers[1:8]
    numbers[7] = temp
    if numbers[7] <= 0:
      numbers[7] = 0
      break
    if a > 5:
      a = 1
  answer = ''
  for n in numbers:
    answer += str(n) + ' '
  print(f"#{t} {answer}")
