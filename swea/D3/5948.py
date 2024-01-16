def dfs(depth, index, number):
  global all_sum
  if depth == 3:
    if not number in all_sum:
      all_sum.append(number)
    return
  
  for i in range(index, 7):
    dfs(depth + 1, i + 1, number + numbers[i])

answer = []
T = int(input())
for tc in range(1, T + 1):
  numbers = list(map(int, input().split()))
  all_sum = []
  dfs(0, 0, 0)
  all_sum.sort(reverse=True)
  answer.append(f"#{tc} {all_sum[4]}")
for ans in answer:
  print(ans)