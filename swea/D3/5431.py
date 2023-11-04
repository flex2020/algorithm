T = int(input())
for tc in range(1, T + 1):
  N, K = map(int, input().split())
  student = [False] * (N + 1)
  array = list(map(int, input().split()))
  for n in array:
    student[n] = True
  answer = ''
  for i in range(1, N + 1):
    if not student[i]:
      answer += str(i) + ' '
  print(f"#{tc} {answer}")