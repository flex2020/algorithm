T = int(input())

for tc in range(1, T + 1):
  N, Q = map(int, input().split())
  array = [0] * (N + 1)
  for i in range(1, Q + 1):
    a, b = map(int, input().split())
    for j in range(a, b + 1):
      array[j] = i
  answer = ''
  for i in range(1, N + 1):
    answer += str(array[i]) + ' '
  print(f"#{tc} {answer}")