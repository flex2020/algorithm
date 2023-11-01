T = int(input())

for tc in range(1, T + 1):
  N = int(input())
  rooms = [list(map(int, input().split())) for _ in range(N)] 
  corridor = [0] * 201
  for a, b in rooms:
    start, end = a, b
    if start > end:
      start, end = end, start
    start = round((start + 0.1) / 2)
    end = round((end + 0.1) / 2)
    for i in range(start, end+1):
      corridor[i] += 1
  
  print(f"#{tc} {max(corridor)}")