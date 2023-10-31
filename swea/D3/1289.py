def change_memory(memory, index, value):
  for i in range(index, len(memory)):
    memory[i] = value

def check_memroy():
  for i in range(N):
    if original[i] != target_memory[i]:
      return False
  return True

T = int(input())

for tc in range(1, T + 1):
  target_memory = list(input())
  answer = 0
  N = len(target_memory)
  original = ['0'] * N
  for i in range(N):
    if check_memroy():
      break
    if target_memory[i] == original[i]:
      continue

    change_memory(original, i, target_memory[i])
    answer += 1

  print(f"#{tc} {answer}")