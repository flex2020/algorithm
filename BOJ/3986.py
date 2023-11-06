N = int(input())
words = [list(input()) for _ in range(N)]
answer = 0
i = 0
for word in words:
  stack = []
  while word:
    if stack:
      if stack[-1] != word[-1]:
        stack.append(word.pop(-1))
      else:
        word.pop(-1)
        stack.pop(-1)
    else:
      stack.append(word.pop(-1))
  if not stack:
    answer += 1
print(answer)