# 문자열 뒤집기
S = input()

group0, group1 = 0, 0

last = S[0]
if last == '0':
  group0 += 1
else:
  group1 += 1

for s in S[1:-1]:
  # 지금까지 문자가 이전 문자랑 다르다면 다른 그룹
  if s != last:
    if s == '0':
      group0 += 1
      last = s
    else:
      group1 += 1
      last = s

print(min(group0, group1))
