def remove_same_number(code):
  global answer
  prev = code[0]
  length = len(code)
  for i in range(1, length):
    # 이어붙은 숫자가 존재하므로 삭제
    if prev == code[i]:
      prev = ''
      if i == 1:
        code = code[2:]
      else:
        code = code[0:i-1] + code[i+1:]
      return code
    # 이전 숫자와 다른 숫자라면 이전 숫자 변경
    prev = code[i]
  answer = code
  return False

for tc in range(1, 11):
  answer = ''
  N, M = map(int, input().split())
  M = str(M)

  while True:
    M = remove_same_number(M)
    if not M:
      break

  print(f"#{tc} {int(answer)}")