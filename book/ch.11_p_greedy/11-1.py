# 모험가 길드
import sys
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))
data.sort()
answer = 0
count = 0 # 그룹원 수
for i in range(N):
  count += 1 # 그룹원 수 추가
  if data[i] == count:
    count = 0
    answer += 1

print(answer)
