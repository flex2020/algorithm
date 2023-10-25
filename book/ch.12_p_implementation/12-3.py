def solution(s):
    length = len(s) # 문자열 기본 길이
    answer = length

    for i in range(1, length + 1):
        sub_s = ''
        new_s = ''
        count = 1
        for j in range(length // i):
            if sub_s == s[j*i:j*i+i]:
                count += 1
            else:
                if count >= 2:
                    new_s += str(count)
                    count = 1
                new_s += sub_s
                sub_s = s[j*i:j*i+i]
        if count >= 2:
            new_s += str(count) + sub_s + s[(length//i)*i:length]
        else:
            new_s += sub_s + s[(length//i)*i:length]
        if len(new_s) == 6:
            print(new_s)
        answer = min(answer, len(new_s))
    return answer