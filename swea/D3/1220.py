def rotate_90(table):
  result = []
  for j in range(100):
    s = ''
    for i in range(100):
      if table[i][j] != '0':
        s += table[i][j]
    result.append(s)

  return result

for tc in range(1, 11):
  answer = 0
  N = int(input())
  table = []
  for i in range(100):
    table.append(list(input().split()))
  str_table = rotate_90(table)

  for i in range(100):
    answer += str_table[i].count('12')

  print(f"#{tc} {answer}")