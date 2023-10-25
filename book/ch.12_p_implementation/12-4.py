from copy import deepcopy

# 시계방향으로 90도 회전
def rotate_clockwise_90(key, M):
    rotated_key = [[0] * M for _ in range(M)]
    for i in range(M):
        for j in range(M):
            rotated_key[j][M - i - 1] = key[i][j]
    return rotated_key

# 자물쇠와 열쇠가 맞는지 확인
def check_new_lock(new_lock, new_key, i, j, N, M):
    for a in range(i, i+M):
        for b in range(j, j+M):
            new_lock[a][b] += new_key[a-i][b-j]
    # 자물쇠의 가운데 부분 확인
    for a in range(N, 2*N):
        for b in range(N, 2*N):
            if new_lock[a][b] != 1:
                return False
    return True

def solution(key, lock):
    answer = True
    N, M = len(lock), len(key)
    new_lock = [[0] * (3*N) for _ in range(3*N)]
    
    # 크기가 3배인 자물쇠 세팅
    for i in range(N, 2*N):
        for j in range(N, 2*N):
            new_lock[i][j] = lock[i-N][j-N]
    
    # 완전탐색 시작
    for i in range(N - M + 1, 2 * N):
        for j in range(N - M + 1, 2 * N):
            # 4번 돌려보면서 확인
            for _ in range(4):
                key = rotate_clockwise_90(key, M)
                if check_new_lock(deepcopy(new_lock), key, i, j, N, M):
                    return True
    return False

