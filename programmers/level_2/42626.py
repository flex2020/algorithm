import heapq
def solution(scoville, K):
    answer = 0
    q = []
    for s in scoville:
        heapq.heappush(q, s)
    while q[0] < K and len(q) >= 2:
        s1 = heapq.heappop(q)
        s2 = heapq.heappop(q)
        s = s1 + s2 * 2
        heapq.heappush(q, s)
        answer += 1
    
    if q[0] < K:
        answer = -1
        
    return answer