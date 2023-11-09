bomb_array = []
def is_enable(m, n, board):
    global bomb_array
    result = False
    for i in range(m-1):
        for j in range(n-1):
            block1 = board[i][j]
            block2 = board[i][j+1]
            block3 = board[i+1][j]
            block4 = board[i+1][j+1]
            # 만약 터진다면 표기
            if block1 != '-' and block1 == block2 and block2 == block3 and block3 == block4:
                result = True
                bomb_array[i][j] = True
                bomb_array[i][j+1] = True
                bomb_array[i+1][j] = True
                bomb_array[i+1][j+1] = True
    return result

def board_down(m, n, board):
    for j in range(n):
        new_col = []
        cnt = 0
        # 현재열에서 비어있는 곳을 뒤로 옮겨준 새로운 열 정보 생성
        for i in range(m-1, -1, -1):
            if board[i][j] == '-':
                cnt += 1
                continue
            new_col.append(board[i][j])
        for i in range(cnt):
            new_col.append('-')
        # 새로운 열 정보를 바탕으로 현재열 변경
        for i in range(m-1, -1, -1):
            board[i][j] = new_col[m-i-1]

def display(m, n, board):
    for i in range(m):
        for j in range(n):
            print(board[i][j], end='')
        print()
            
def solution(m, n, board):
    global bomb_array
    board = [list(board[i]) for i in range(m)]
    answer = 0
    bomb_array = [[False] * n for _ in range(m)]
    while is_enable(m, n, board):
        # 현재 폭발 가능한 블럭 삭제
        for i in range(m):
            for j in range(n):
                if bomb_array[i][j]:
                    bomb_array[i][j] = False
                    board[i][j] = '-'
                    answer += 1
        # 밑으로 당김
        board_down(m, n, board)
    
    
    return answer