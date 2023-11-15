def get_lcm(a, b):
  # 더 큰 수를 a로 설정
  if b > a: a, b = b, a
  for i in range(a, (a * b) + 1):
    if i % a == 0 and i % b == 0:
      return i

T = int(input())

for tc in range(1, T + 1):
  s1, s2 = input().split()
  answer = "no"
  s1_len, s2_len = len(s1), len(s2)
  # s1, s2 길이의 최소공배수를 구한다.
  lcm = get_lcm(s1_len, s2_len)
  # s1과 s2의 길이를 맞춰준다.
  new_s1, new_s2 = s1, s2
  while len(new_s1) != lcm:
    new_s1 += s1
  while len(new_s2) != lcm:
    new_s2 += s2
  if new_s1 == new_s2:
    answer = "yes"
  

  print(f"#{tc} {answer}")