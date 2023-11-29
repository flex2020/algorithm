T = int(input())

for tc in range(1, T + 1):
  s = input()
  answer = 0
  if s == s[::-1]: answer = 1
  print(f"#{tc} {answer}")