import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
answer = [N]
for i in range(N-2, -1, -1):
  answer.insert(data[i], i + 1)

for ans in answer:
  print(ans, end=' ')