N, M = map(int, input().split())

x, y, dir = map(int, input().split())

# 방향은 북 -> 동 -> 남 -> 서 순서
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
gameMap = []
answer = 1
for _ in range(N):
    row = list(map(int, input().split()))
    gameMap.append(row)

visited = [[0] * M for _ in range(N)]

cnt = 0
while True:
    if cnt == 4:
        break
    dir -= 1
    cnt += 1
    nx = x + dx[dir % 4]
    ny = x + dx[dir % 4]
    # 다음 갈 곳이 바다거나 방문했던 곳이면 방향ㄴ 다시 설정
    if gameMap[nx][ny] == 1 or visited[nx][ny] == 1:
        continue
    # 갈 수 있는 곳이라면 방문, 방문체크, answer 증가
    x, y = nx, ny
    answer += 1
    visited[x][y] = 1

print(answer)