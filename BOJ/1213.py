import sys
from collections import Counter

input = sys.stdin.readline

eng_name = list(input().strip())
eng_name.sort()
check = Counter(eng_name)

cnt = 0
center = ''
half = ''
for i in check:
  if check[i] % 2 == 1:
    cnt += 1
    if cnt == 2:
      break
    center = i
    check[i] -= 1
if cnt == 2:
  print("I'm Sorry Hansoo")
else:
  for i in check:
    if check[i] % 2 == 0:
      for _ in range(check[i] // 2):
        half += i
  answer = half + center + half[::-1]
  print(answer)