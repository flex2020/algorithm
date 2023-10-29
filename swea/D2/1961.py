def rotate_matrix_90(matrix):
  new_matrix = [[0] * N for _ in range(N)]
  for i in range(N):
    for j in range(N):
      new_matrix[i][j] = matrix[N-j-1][i]
  return new_matrix
T = int(input())

for t in range(1, T + 1):
  N = int(input())
  matrix = []
  for _ in range(N):
    matrix.append(list(map(int, input().split())))
  mat_list = []
  mat_list.append(rotate_matrix_90(matrix))
  mat_list.append(rotate_matrix_90(mat_list[0]))
  mat_list.append(rotate_matrix_90(mat_list[1]))
  print(f"#{t}")
  for i in range(N):
    for k in range(3):
      for j in range(N):
        print(mat_list[k][i][j], end='')
      print(end=' ')
    print()