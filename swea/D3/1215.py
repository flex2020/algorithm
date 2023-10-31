# 배열의 가로 세로 위치 변환
def rotate_90(array):
  result = [[''] * 8 for _ in range(8)]
  
  for i in range(8):
    for j in range(8):
      result[i][j] = array[j][i]
  return result

def count_palindromes(array):
  global answer
  for i in range(8):
    for j in range(0, 9-N):
      word = array[i][j:j+N]
      if word == word[::-1]:
        answer += 1

def display(array):
  for i in range(8):
    for j in range(8):
      print(array[i][j], end='')
    print()

for tc in range(1, 11):
  N = int(input())
  graph = []
  for i in range(8):
    graph.append(input())
  answer = 0
  # 가로 방향 회문 확인
  count_palindromes(graph)
  graph = rotate_90(graph)
  # 가로 방향 회문 확인
  count_palindromes(graph)
  print(f"#{tc} {answer}")