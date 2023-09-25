N = int(input())
parts = set(map(int, input().split()))

M = int(input())
request_parts = list(map(int, input().split()))

for rp in request_parts:
  if rp in parts:
    print("yes", end=' ')
  else:
    print("no", end=' ')