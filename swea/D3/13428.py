def change_number(i, j, list_number):
  global min_ans, max_ans

  list_number[i], list_number[j] = list_number[j], list_number[i]
  if list_number[0] == '0':
    list_number[i], list_number[j] = list_number[j], list_number[i]
    return
  snum = list_to_string(list_number)
  min_ans = min(min_ans, int(snum))
  max_ans = max(max_ans, int(snum))
  list_number[i], list_number[j] = list_number[j], list_number[i]

def list_to_string(l):
  s = ''
  for n in l:
    s += n
  return s

T = int(input())

for tc in range(1, T + 1):
  N = list(input())
  min_ans = int(list_to_string(N))
  max_ans = int(list_to_string(N))
  nlen = len(N)
  for i in range(nlen - 1):
    for j in range(i + 1, nlen):
      change_number(i, j, N)
  print(f"#{tc} {min_ans} {max_ans}")