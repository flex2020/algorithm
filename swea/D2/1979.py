T = int(input())

for t in range(1, T + 1):
  N, K = map(int, input().split())
  graph = []
  for i in range(N):
    graph.append(list(map(int, input().split())))
  answer = 0
  # 가로 방향으로 단어가 들어갈 자리가 있는지 살펴봄
  for i in range(N):
    count = 0
    for j in range(N):
      # 흰색 부분을 만난 경우
      if graph[i][j] == 1:
        count += 1
      # 흰색 부분을 만났다가 검정부분을 만난 경우
      elif count > 0 and graph[i][j] == 0:
        # 만약 글자 수만큼 칸이 있다면 추가
        if count == K:
          answer += 1
        count = 0
    if count == K:
      answer += 1
    count = 0
  # 세로 방향으로 단어가 들어갈 자리가 있는지 살펴봄
  for j in range(N):
    count = 0
    for i in range(N):
      # 흰색 부분을 만난 경우
      if graph[i][j] == 1:
        count += 1
      # 흰색 부분을 만났다가 검정부분을 만난 경우
      elif count > 0 and graph[i][j] == 0:
        # 만약 글자 수만큼 칸이 있다면 추가
        if count == K:
          answer += 1
        count = 0
    if count == K:
      answer += 1
    count = 0

  
  print(f"#{t} {answer}")