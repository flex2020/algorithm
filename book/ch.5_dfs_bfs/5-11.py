from collections import deque

N, M = map(int, input().split())
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

graph = []

for i in range(N):
  graph.append(list(map(int, input())))

visited = [False * M for _ in range(N)]

def bfs():
  # 큐에 시작점 추가
  queue = deque([(0, 0)])
  
  # 큐가 빌 때까지 반복
  while queue:
    x, y = queue.popleft()

    # 현재 위치에서 네 방향 중 갈 수 있는 곳 확인
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      # 다음 갈 곳이 미로 공간이 아닌 경우 갈 수 없음
      if nx < 0 or nx >= N or ny < 0 or ny >= M:
        continue
      # 미로 공간에 포함되지만, 벽인 경우 무시
      if graph[nx][ny] == 0:
        continue
      
      # 갈 수 있다면 다음 위치 카운트 증가 및 큐에 삽입
      if graph[nx][ny] == 1:
        graph[nx][ny] = graph[x][y] + 1
        queue.append((nx, ny))

bfs()

print(graph[N-1][M-1])
