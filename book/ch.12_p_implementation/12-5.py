import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
K = int(input())

board = [[0] * N for _ in range(N)]
apples = []
q = deque()
for _ in range(K):
  apple_x, apple_y = map(int, input().split())
  apples.append((apple_x - 1, apple_y - 1))
L = int(input())
for _ in range(L):
  x, c = input().split()
  q.append((int(x), c))
x, y, length, dir = 0, 0, 1, 0
snake = deque([(0, 0)])
d = [[0, 1], [1, 0], [0, -1], [-1, 0]]

answer = 0 # 현재 게임 시간
while True:
  answer += 1
  # 이동
  x += d[dir][0]
  y += d[dir][1]
  
  # 이동 후 자신의 몸이 있거나, 머리가 벽에 부딪힌 경우
  if (x, y) in snake or x < 0 or x >= N or y < 0 or y >= N:
    print(answer)
    break
  # 이동 후 해당 위치에 사과가 있다면 몸길이를 늘림
  if (x, y) in apples:
    apples.remove((x, y)) # 사과 제거
    length += 1
  else:
    snake.popleft() # 꼬리 부분 제거
  snake.append((x, y))

  # 방향전환 시점이라면
  if q and q[0][0] == answer:
    temp, c = q.popleft()
    # 왼쪽으로 90도 회전
    if c == 'L':
      dir = (dir - 1) % 4
    # 오른쪽으로 90도 회전
    else:
      dir = (dir + 1) % 4



