from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    cmpl_count = 0
    wait_q = deque([])
    bridge_q = deque([])
    bridge_l = 0
    bridge_w = 0
    for w in truck_weights: wait_q.append(w)
    while cmpl_count < len(truck_weights):
        answer += 1
        pop_cnt = 0
        # 다리에 있는 모든 트럭의 위치를 1칸씩 이동
        if bridge_q:
            for t in bridge_q:
                t[1] += 1
                if t[1] == bridge_length:
                    bridge_l -= 1
                    bridge_w -= t[0]
                    pop_cnt += 1
        cmpl_count += pop_cnt
        for _ in range(pop_cnt):
            bridge_q.popleft()
        # 1초마다 대기큐가 비어있지 않고 트럭이동이 가능하면 트럭이동
        if wait_q and bridge_w + wait_q[0] <= weight and bridge_l + 1 <= bridge_length:
            w = wait_q.popleft()
            bridge_w += w
            bridge_l += 1
            bridge_q.append([w, 0])


    return answer