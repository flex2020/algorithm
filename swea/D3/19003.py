T = int(input())

for tc in range(1, T + 1):
  answer = 0
  N, M = map(int, input().split())
  palindrome = 0 # 팰린드롬의 수
  not_palindrome = [] # 팰린드롬이 아닌 문자열들
  for _ in range(N):
    s = input()
    if s == s[::-1]: palindrome = 1 # 팰린드롬은 최대 1개
    else: not_palindrome.append(s) # 팰린드롬이 아니라면 리스트에 추가
  
  pair_count = 0 # 대칭이 되는 문자열의 수
  nplen = len(not_palindrome) # 팰린드롬이 아닌 문자열의 수
  check = [False] * nplen # 이미 대칭인 경우는 탐색하지 않도록
  for i in range(nplen):
			# 아직 탐색하지 않은 문자열 중 현재 문자열과 대칭이 되는 문자열이 존재하면
      if not check[i] and not_palindrome[i][::-1] in not_palindrome:
        pair_count += 2
        check[i] = True # 현재 문자열 체크
        index = not_palindrome.index(not_palindrome[i][::-1]) # 대칭인 문자열의 위치
        check[index] = True # 대칭 문자열 체크
      
  answer = (pair_count + palindrome) * M # 총 문자열의 길이 반환

  print(f"#{tc} {answer}")