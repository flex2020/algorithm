N, K = map(int, input().split())

people = [i for i in range(1, N + 1)]
index = K - 1
answer = []
while people:
  if index >= len(people):
    index %= len(people)
  
  p = people.pop(index)
  answer.append(p)
  index += K - 1

print("<", end='')
for i in range(N):
  if i != N - 1:
    print(f"{answer[i]}, ", end='')
  else:
    print(f"{answer[i]}>")