T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    data = list(map(int, input().split()))
    # 거꾸로 계산
    # 판매 금액을 마지막으로 설정
    sell_price = data[-1]
    answer = 0
    for i in range(N-2, -1, -1):
        # 판매금액보다 적은경우 이득을 더함
        if data[i] < sell_price:
            answer += sell_price - data[i]
        # 판매금액보다 큰 경우는 새로운 판매 금액으로 설정
        elif data[i] > sell_price:
            sell_price = data[i]        
    print(f"#{test_case} {answer}")