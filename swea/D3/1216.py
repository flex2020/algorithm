def rotate_90(array):
  result = [[''] * 100 for _ in range(100)]
  for i in range(100):
    for j in range(100):
      result[i][j] = array[j][i]
  
  return result

def find_palinedrome(array, N):
  for i in range(100):
    for j in range(101-N):
      word = array[i][j:j+N]
      if word == word[::-1]:
        return True
  return False

for _ in range(1, 11):
  tc = int(input())
  answer = 100
  graph = []
  rotated_graph = []
  for i in range(100):
    graph.append(list(input()))
  rotated_graph = rotate_90(graph)

  while answer != 0:
    if find_palinedrome(graph, answer):
      break
    if find_palinedrome(rotated_graph, answer):
      break
    answer -= 1


  print(f"#{tc} {answer}")