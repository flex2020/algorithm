T = int(input())
answer = []
alphabet = list('abcdefghijklmnopqrstuvwxyz')
for tc in range(1, T + 1):
  s = input()
  ans = 0
  for i in range(len(s)):
    if alphabet[i] != s[i]:
      break
    ans += 1

  answer.append(f"#{tc} {ans}")
for ans in answer:
  print(ans)