primes = [2]
for i in range(3, int(1e7 ** 0.5), 2):
  for p in primes:
    if i % p == 0:
      break
  else:
    primes.append(i)
  
T = int(input())
answer = []
for tc in range(1, T + 1):
  A = int(input())
  temp = 1
  # 이미 제곱수라면 1 추가만함
  if A ** 0.5 == int(A ** 0.5):
    answer.append(f'#{tc} {1}')
    continue
  for p in primes:
    cnt = 0
    while A % p == 0:
      A //= p
      cnt += 1
    if cnt % 2 != 0:
      temp *= p
    if A == 1 or p > A:
      break
  if A > 1:
    temp *= A
  answer.append(f'#{tc} {temp}')

for ans in answer:
  print(ans)