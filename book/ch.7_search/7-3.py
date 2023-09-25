def binary_search(array, target, start, end):
  mid = (start + end) // 2
  if start > end:
    return None
  
  if array[mid] == target:
    return mid
  elif array[mid] > target:
    return binary_search(array, target, start, mid - 1)
  else:
    return binary_search(array, target, mid + 1, end)
  
N = int(input())
parts = list(map(int, input().split()))

M = int(input())
request_parts = list(map(int, input().split()))

parts.sort()

for rp in request_parts:
  result = binary_search(parts, rp, 0, N)
  if result == None:
    print("no", end=' ')
  else:
    print("yes", end=' ')
