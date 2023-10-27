for test_case in range(1, 11):
    N = int(input())
    building = list(map(int, input().split()))
    answer = 0
    for i in range(2, N-2):
        if building[i] > building[i-2] and building[i] > building[i-1] and building[i] > building[i+1] and building[i] > building[i+2]:
            answer += building[i] - max(building[i-2], building[i-1], building[i+1], building[i+2])
    print(f"#{test_case} {answer}")