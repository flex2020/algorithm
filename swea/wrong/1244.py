def dfs(list_number, depth):
  global answer
  if depth == M:
    snum = ''
    for n in list_number:
      snum += n
    answer = max(answer, int(snum))
    return
  
  for i in range(list_len-1):
    for j in range(i+1, list_len):
      list_number[i], list_number[j] = list_number[j], list_number[i]
      dfs(list_number, depth + 1)
      list_number[i], list_number[j] = list_number[j], list_number[i]


T = int(input())

for tc in range(1, T + 1):
  N, M = map(int, input().split())
  answer = 0
  list_number = list(str(N))
  list_len = len(list_number)
  M = min(M, 6)
  dfs(list_number, 0)

  print(f"#{tc} {answer}")