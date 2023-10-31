for _ in range(1, 11):
  tc = int(input())
  target = input()
  string = input()
  answer = string.count(target)

  print(f"#{tc} {answer}")