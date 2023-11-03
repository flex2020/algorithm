T = int(input())

for tc in range(1, T + 1):
  data = input()
  cards = [0] * 13 * 4
  answer = ''
  flag = False
  for i in range(0, len(data), 3):
    type = data[i]
    number = int(data[i+1] + data[i+2]) - 1
    a = 0
    if type == 'D':
      a = 1
    elif type == 'H':
      a = 2
    elif type == 'C':
      a = 3
    
    # 카드가 이미 있는지 확인
    if cards[a * 13 + number] == 1:
      flag = True
      break
    cards[a * 13 + number] = 1
  
  if flag:
    print(f"#{tc} ERROR")
    continue
  for i in range(4):
    answer += str(13 - sum(cards[i*13:(i+1)*13])) + ' '
  print(f"#{tc} {answer}")