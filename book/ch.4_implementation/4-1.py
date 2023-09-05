N = int(input())
data = list((input().split()))

x, y = 1, 1

for i in range(len(data)):
  if data[i] == "L" and y > 1:
    y -= 1
  elif data[i] == "R" and y < N:
    y += 1
  elif data[i] == "U" and x > 1:
    x -= 1
  elif data[i] == "D" and x < N:
    x += 1

print(x, y)