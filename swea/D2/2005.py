# 파스칼의 삼각형 10개짜리 초기화
triangle = [[0] * 10 for _ in range(10)]
for i in range(10):
  for j in range(i+1):
    if j == 0 or j == i:
      triangle[i][j] = 1
    else:
      triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]  

T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  answer = ''
  for i in range(N):
    for j in range(i+1):
      answer += str(triangle[i][j]) + ' '
    if i != N - 1: answer += '\n'


  print(f"#{tc}\n{answer}")