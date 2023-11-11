number_list = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F']
def get_target(number, n):
    snum = ''
    while number > 1:
        snum += number_list[number % n]
        number //= n
    if number != 0:
        snum += number_list[number]
        
    return snum[::-1]
def solution(n, t, m, p):
    answer = ''
    number = 0 # 게임 진행 중 숫자
    target = '0'
    target_index = 0
    snumber = ''
    order = 1
    cnt = 0 # 현재 답을 말한 횟수
    while cnt < t:
        # 다음 숫자 준비
        if target == snumber:
            number += 1
            target = get_target(number, n)
            target_index = 0
            target_len = len(target)
            snumber = ''
        else:
            snumber += target[target_index]
            if order == p:
                cnt += 1
                answer += target[target_index]
            target_index += 1
            order += 1
            if order > m:
                order = 1
        
    
    return answer