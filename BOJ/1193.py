X = int(input())
line = 1
end = 0
while end < X:
  end += line
  line += 1

if line % 2 == 0:
  a = end - X + 1
  b = X + line - end - 1
else:
  a = X + line - end - 1
  b = end - X + 1  
print(f"{a}/{b}")