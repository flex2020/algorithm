import heapq

alphabet = ['A', 'E', 'I', 'O', 'U']
words = []
def dfs(length, target_length, w):
    if length == target_length:
        heapq.heappush(words, w)
        return
    for i in range(5):
        dfs(length + 1, target_length, w + alphabet[i])
        
def solution(word):
    for i in range(1, 6):
        dfs(0, i, '')
    answer = 0
    while True:
        answer += 1
        w = heapq.heappop(words)
        if w == word:
            break
    return answer