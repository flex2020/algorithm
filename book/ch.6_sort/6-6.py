N = int(input())

array = []

for i in range(N):
  data = input().split()

  array.append((data[0], int(data[1])))

array.sort(key=lambda student: student[1])

for s in array:
  print(s[0], end=' ')