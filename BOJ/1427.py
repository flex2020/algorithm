N = input()
array = [0] * 10
for n in N:
  array[int(n)] += 1
answer = ''
for i in range(9, -1, -1):
  for j in range(array[i]):
    answer += str(i)
print(answer)