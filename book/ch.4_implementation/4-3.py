pos = input()

x = int(ord(pos[0])) - int(ord('a'))
y = int(pos[1]) - 1

# 나이트가 이동할 수 있는 방향 정의
dir = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2)]

answer = 0
for step in dir:
  next_x = x + step[0]
  next_y = y + step[1]

  if next_x >= 0 and next_x < 8 and next_y >= 0 and next_y < 8:
    answer += 1

print(answer)