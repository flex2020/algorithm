N = input()

half = int(len(N) / 2)
left = 0
right = 0

for i in range(half):
  left += int(N[i])
for i in range(half, len(N)):
  right += int(N[i])
  
if left == right:
  print("LUCKY")
else:
  print("READY")