def init_dictionary():
    dic = {}
    for i in range(1, 27):
        dic[chr(64 + i)] = i
    return dic
def solution(msg):
    answer = []
    mlen = len(msg)
    index = 27
    dic = init_dictionary()
    j = 0
    text = ''
    for i in range(mlen):
        if text == msg:
            break
        if j != i:
            continue
        w = msg[i]
        offset = 1
        c = w
        while w in dic:
            result = dic[w]
            c = w
            if i + offset >= mlen:
                break
            w += msg[i+offset]
            offset += 1
        offset -= 1
        text += c
        if not w in dic:
            dic[w] = index
            index += 1
        answer.append(result)
        j = i + offset  
    
    return answer