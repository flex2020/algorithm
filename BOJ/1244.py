N = int(input())
switch = list(map(int, input().split()))
M = int(input())
for _ in range(M):
  gender, number = map(int, input().split())
  if gender == 1:
    for i in range(number, N + 1, number):
      switch[i-1] ^= 1
  else:
    index = number - 1
    switch[index] ^= 1
    di = 1
    while True:
      if index - di < 0 or index + di >= N:
        break
      # 양 옆이 같다면 바꿈
      if switch[index - di] == switch[index + di]:
        switch[index - di] ^= 1
        switch[index + di] ^= 1
        di += 1
      else:
        break
line = N // 20 + 1
for i in range(line):
  if N >= 20:
    N -= 20
    end = 20
  else:
    end = N
  for j in range(end):
    print(switch[i*20 + j], end=' ')
  print()