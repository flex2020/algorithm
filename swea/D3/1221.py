T = int(input())
eng_to_number = {
  'ZRO': 0,
  'ONE': 1,
  'TWO': 2,
  'THR': 3,
  'FOR': 4,
  'FIV': 5,
  'SIX': 6,
  'SVN': 7,
  'EGT': 8,
  'NIN': 9
}

number_to_eng = {
  0: 'ZRO',
  1: 'ONE',
  2: 'TWO',
  3: 'THR',
  4: 'FOR',
  5: 'FIV',
  6: 'SIX',
  7: 'SVN',
  8: 'EGT',
  9: 'NIN'
}

for tc in range(1, T + 1):
  N = input().split()[1]
  data = list(input().split())
  answer = ''
  counting = [0] * 10 # 숫자가 9까지 있으니 크기를 10으로 지정
  for i in range(len(data)):
    counting[eng_to_number[data[i]]] += 1
  
  for i in range(10):
    answer += (number_to_eng[i] + ' ') * counting[i]

  print(f"#{tc} {answer}")