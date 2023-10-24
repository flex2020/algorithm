# 곱하기 혹은 더하기
import sys
input = sys.stdin.readline

numbers = input()
answer = 0 # 이전까지의 계산결과
for number in numbers[0:-1]:
  number = int(number)
  answer = max(answer + number, answer * number)

print(answer)