N, M = map(int, input().split())
array = list(map(int, input().split()))

array.sort()

start = 0
end = max(array)

answer = 0
while start <= end:
  total = 0
  mid = (start + end) // 2
  
  for x in array:
    if x > mid:
      total += x - mid
  if total < M:
    end = mid - 1
  else:
    answer = mid
    start = mid + 1

print(answer)