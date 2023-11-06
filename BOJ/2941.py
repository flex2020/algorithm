cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
answer = 0
s = list(input())

while s:
  if len(s) >= 3:
    if s[0] + s[1] + s[2] in cro:
      answer += 1
      for _ in range(3): s.pop(0)
    elif s[0] + s[1] in cro:
      answer += 1
      for _ in range(2): s.pop(0)
    else:
      answer += 1
      s.pop(0)
  elif len(s) == 2:
    if s[0] + s[1] in cro:
      answer += 1
      break
    else:
      answer += 2
      break
  else:
    answer += 1
    break
    

print(answer)