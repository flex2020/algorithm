
T = int(input())
number = ['0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111', '0111011', '0110111', '0001011']
def solve(code):
  cn = []
  for i in range(0, 56, 7):
    n = number.index(code[i:i+7])
    cn.append(n)
  
  verify_code = sum(cn[0:8:2]) * 3 + sum(cn[1:9:2])

  if verify_code % 10 != 0:
    return False
  return sum(cn)

for t in range(1, T + 1):
  N, M = map(int, input().split())
  code = ''
  answer = 0
  for i in range(N):
    s = input()
    if not '1' in s:
      continue
    code = s
  
  index = 0
  for i in range(M):
    if code[i] == '1':
      index = i
  new_code = ''
  for i in range(index - 55, index + 1):
    new_code += code[i]

  answer = solve(new_code)

  if not answer:
    answer = 0
  print(f"#{t} {answer}")