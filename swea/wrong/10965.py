prime = [2]
end = int(1e7 ** 0.5) + 1
# 에라토스테네스의 체 이용하여 소수를 빠르게 찾음
for i in range(3, end, 2):
  for p in prime:
    if i % p == 0:
      break
  else:
    prime.append(i)
T = int(input())
answer_list = []
for tc in range(1, T + 1):
  N = int(input())
  temp = N
  # 이미 제곱수인 경우
  if int(N ** 0.5) == N ** 0.5:
    answer_list.append(f"#{tc} 1")
    continue

  # 소인수분해 시작
  prime_index = 0
  answer = 1
  for p in prime:
    cnt = 0
    while temp % p == 0:
      temp //= p
      cnt += 1
    if cnt % 2 == 1:
      answer *= p
    if temp == 1 or p > temp:
      break
  if temp > 1:
    answer *= temp
  answer_list.append(f"#{tc} {answer}")

for ans in answer_list:
  print(ans)