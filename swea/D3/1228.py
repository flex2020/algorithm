for tc in range(1, 11):
  answer = ''
  N = int(input())
  origin = list(input().split())
  M = int(input())
  ops = input().split('I')
  for i in range(1, M + 1):
    op = ops[i].split()
    index = int(op[0])
    count = int(op[1])
    for j in range(count):
      origin.insert(index + j, op[2+j])

  for i in range(10):
    answer += origin[i] + ' '

  print(f"#{tc} {answer}")