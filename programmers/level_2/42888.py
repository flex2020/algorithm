def solution(record):
    answer = []
    data = []
    users = {}
    for r in record:
        sr = r.split()
        # 유저 나감
        if len(sr) == 2:
            uid = sr[1]
            data.append((0, uid))
        # 유저 입장 및 닉네임 변경
        else:
            op, uid, nickname = sr
            if op == 'Enter':
                data.append((1, uid))
            users[uid] = nickname
    for d in data:
        op, uid = d
        # 나간 경우
        if op == 0:
            answer.append(f"{users[uid]}님이 나갔습니다.")
        else:
            answer.append(f"{users[uid]}님이 들어왔습니다.")
    
    return answer