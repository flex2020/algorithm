prime = [2]
for i in range(3, 1000):
  for p in prime:
    if i % p == 0:
      break
  else:
    prime.append(i)

T = int(input())

for tc in range(1, T + 1):
  answer = 0
  N = int(input())
  plen = len(prime)
  # 첫번째 소수 고름
  for i in range(plen):
    temp = N
    p1 = prime[i]
    temp -= p1
    # 두번째 소수 고름
    for j in range(i, plen):
      temp2 = temp
      p2 = prime[j]
      temp2 -= p2
      # 남은 수가 소수인지 확인
      if temp2 in prime[j:]:
        answer += 1
  print(f"#{tc} {answer}")