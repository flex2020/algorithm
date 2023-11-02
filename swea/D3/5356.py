T = int(input())

for tc in range(1, T + 1):
  answer = ''
  words = [list(input()) for _ in range(5)]

  max_length = 0
  for i in range(5):
    max_length = max(max_length, len(words[i]))
  
  for i in range(5):
    for j in range(len(words[i]), max_length):
      words[i].append('')
  
  for j in range(max_length):
    for i in range(5):
      answer += words[i][j]

  print(f"#{tc} {answer}")