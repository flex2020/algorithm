T = int(input())

for t in range(1, T + 1):
  answer = 0
  N = int(input())
  farm = []
  for i in range(N):
    farm.append(list(map(int, input())))
  
  mid = N // 2
  stack = []
  for i in range(N):
    start, end = 0, 0
    if i < mid:
      start = mid - i
      end = mid + i
      stack.append((start, end))
    elif i == mid:
      start = 0
      end = N-1
    else:
      start, end = stack.pop()
    
    
    for j in range(start, end + 1):
      answer += farm[i][j]

  print(f"#{t} {answer}")