N = int(input())
parts = [0] * 1000001

for i in input().split():
  parts[int(i)] = 1 

M = int(input())
request_parts = list(map(int, input().split()))

for rp in request_parts:
  if parts[rp] == 1:
    print("yes", end=' ')
  else:
    print("no", end=' ')