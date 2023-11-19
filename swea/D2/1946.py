T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  s = ''
  for i in range(N):
    c, n = input().split()
    n = int(n)
    for i in range(n):
      s += c
  
  answer = ''
  for i in range(len(s)):
    if i > 0 and (i+1) % 10 == 0:
      answer += s[i] + '\n'
    else:
      answer += s[i]
  print(f"#{tc}")
  print(answer)
  