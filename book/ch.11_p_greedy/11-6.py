import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    q = []
    foods = len(food_times)
    for i in range(foods):
        heapq.heappush(q, (food_times[i], i + 1))
    
    foods = len(food_times)
    sum_value = 0
    prev = 0
    
    while sum_value + ((q[0][0] - prev) * foods) <= k:
        now = heapq.heappop(q)[0] # 현재 요소의 푸드타임
        sum_value += (now - prev) * foods
        foods -= 1 # 다 먹은 음식 제외
        prev = now # 이전 음식 시간 재설정
    
    result = sorted(q, key = lambda x: x[1])
    
    return result[(k - sum_value) % foods][1]