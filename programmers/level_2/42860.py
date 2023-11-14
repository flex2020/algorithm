from copy import deepcopy
# 상하 횟수
vertical = 0
def get_vertical_count(name, nlen):
    global vertical, target
    vertical = 0
    default = ['A' for _ in range(nlen)]
    for i in range(nlen):
        if default[i] != name[i]:
            up_count = ord(name[i]) - 65
            vertical += min(up_count, 26 - up_count)
            target.append(i)

# 좌우 횟수
target = []
horizontal = int(1e9)
def dfs(name, nlen, x, count, depth, visited):
    global horizontal
    if count == len(target):
        horizontal = min(horizontal, depth)
        return
    if depth == nlen: return
    
    if name[x] != 'A' and x in target and not visited[x]:
        visited[x] = True
        count += 1
    nx1, nx2 = x + 1, x - 1
    if nx1 >= nlen: nx1 -= nlen
    if nx2 < 0: nx2 += nlen
    dfs(name, nlen, nx1, count, depth + 1, deepcopy(visited))
    dfs(name, nlen, nx2, count, depth + 1, deepcopy(visited))
    


def solution(name):
    global vertical, horizontal
    answer = 0
    nlen = len(name)
    visited = [False] * nlen
    get_vertical_count(name, nlen)
    dfs(name, nlen, 0, 0, 0, deepcopy(visited))
    answer = vertical + horizontal - 1
    return max(0, answer)