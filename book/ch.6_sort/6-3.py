array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

# 퀵정렬

def quick_sort(array):
  if len(array) <= 1:
    return array
  
  pivot = array[0]
  tail = array[1:]

  left_side = [x for x in tail if x <= pivot] # pivot 보다 작은 숫자들을 왼쪽으로
  right_side = [x for x in tail if x > pivot] # pivot 보다 큰 숫자들을 오른쪽으로

  return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(array))