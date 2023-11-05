from collections import deque
def bfs(start_x, start_y, start_direction, N, M, grid, answer, visited):
    q = deque([(start_x, start_y, start_direction, 1)])
    visited[start_x][start_y][start_direction] = True
    
    while q:
        x, y, d, l = q.popleft()
        
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0:
            nx = N - 1
        elif nx >= N:
            nx = 0
        if ny < 0:
            ny = M - 1
        elif ny >= M:
            ny = 0
        nd = d
        if grid[nx][ny] == 'L':
            nd = (d - 1) % 4
        elif grid[nx][ny] == 'R':
            nd = (d + 1) % 4
        
        if not visited[nx][ny][nd]:
            q.append((nx, ny, nd, l + 1))
            visited[nx][ny][nd] = True
        else:
            answer.append(l)

    
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def solution(grid):
    answer = []
    N, M = len(grid), len(grid[0])
    visited = [[[False] * 4 for _ in range(M)] for _ in range(N)]
    for i in range(N):
        for j in range(M):
            for k in range(4):
                if not visited[i][j][k]:
                    bfs(i, j, k, N, M, grid, answer, visited)
    answer.sort()
    return answer