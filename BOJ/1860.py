T = int(input())

for test_case in range(1, T + 1):
  answer = 'Possible'
  bread = 0
  time = 0
  N, M, K = map(int, input().split())
  temp = list(map(int, input().split()))
  length = max(temp) + 1
  schedule = [0] * length
  for i in range(N):
    schedule[temp[i]] += 1
  
  while True:
    if time >= length:
      break
    end = time + M
    if end > length:
      end = length
    # 일단 남은 손님에게 붕어빵을 준다
    for i in range(time, end):
      if schedule[i] > 0:
        bread -= schedule[i]
        schedule[i] = 0
    # 붕어빵이 음수라면 못 주는 것이므로 불가능
    if bread < 0:
      answer = 'Impossible'
      break
    time += M
    bread += K

  print(f"#{test_case} {answer}")