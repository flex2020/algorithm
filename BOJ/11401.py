def div(a, p):
  if p == 0:
    return 1
  tmp = div(a, p // 2)
  ret = pow(tmp, 2) % P
  if p % 2 == 0:
    return ret
  return (ret * a) % P


P = 1000000007
N, R = map(int, input().split())
R = min(R, N-R)
a, b = 1, 1
for i in range(R):
  a = a * (N - i) % P
  b = b * (R - i) % P
answer =  ((a % P) * (div(b, P - 2) % P)) % P 
print(answer)