def solution(prices):
    plen = len(prices)
    answer = [0] * plen
    stack = []
    for i in range(plen):
        if not stack:
            stack.append((prices[i], i))
            continue
        
        top_value, top_index = stack[-1]
        if top_value <= prices[i]:
            stack.append((prices[i], i))
        else:
            while stack and stack[-1][0] > prices[i]:
                value, index = stack.pop(-1)
                answer[index] = i - index
            stack.append((prices[i], i))
    while stack:
        value, index = stack.pop(-1)
        answer[index] = plen - index - 1
    
    return answer