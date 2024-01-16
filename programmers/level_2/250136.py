from collections import deque

def bfs(start_x, start_y, visited, land):
    q = deque([(start_x, start_y)])
    visited[start_x][start_y] = True
    oil = 1
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if land[nx][ny] == 1 and not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    oil += 1
    return oil
        
    
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
    
n = 0
m = 0
def solution(land):
    global n, m
    n = len(land)
    m = len(land[0])
    answer = 0
    for j in range(m):
        visited = [[False] * m for _ in range(n)]
        oil = 0
        for i in range(n):
            if land[i][j] == 1 and not visited[i][j]:
                oil += bfs(i, j, visited, land)
        answer = max(answer, oil)
    return answer