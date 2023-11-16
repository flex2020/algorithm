T = int(input())

def rotate_90(array):
  new_array = [[0] * 9 for _ in range(9)]
  for i in range(9):
    for j in range(9):
      new_array[i][j] = array[j][i]
  return new_array

for tc in range(1, T + 1):
  answer = 1
  sdk = [list(map(int, input().split())) for _ in range(9)]
  
  # 행 확인
  for i in range(9):
    for j in range(1, 10):
      if not j in sdk[i]:
        answer = 0
        break
    if answer == 0:
      break
  if answer == 0:
    print(f"#{tc} {answer}")
    continue
  # 열 확인
  rotated_sdk = rotate_90(sdk)
  for i in range(9):
    for j in range(1, 10):
      if not j in rotated_sdk[i]:
        answer = 0
        break
    if answer == 0:
      break
  if answer == 0:
    print(f"#{tc} {answer}")
    continue
  
  # 박스 9개 확인
  for i in range(0, 9, 3):
    for j in range(0, 9, 3):
      visited = [0] * 9
      for di in range(3):
        for dj in range(3):
          ni = i + di
          nj = j + dj
          number = sdk[ni][nj]
          visited[number-1] = 1
      if sum(visited) != 9:
        answer = 0
        break
    if answer == 0:
      break

  print(f"#{tc} {answer}")