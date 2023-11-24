T = int(input())
money_list = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
for tc in range(1, T + 1):
  money = int(input())
  answer = ''
  for i in range(len(money_list)):
    count = money // money_list[i]
    answer += str(count) + ' '
    money %= money_list[i]
  print(f"#{tc}\n{answer}")