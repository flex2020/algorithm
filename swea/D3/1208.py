for t in range(1, 11):
    N = int(input()) # 덤프횟수
    box = list(map(int, input().split()))
    answer = max(box) - min(box)
    # N번 평탄화
    for i in range(N):
        max_index, min_index = box.index(max(box)), box.index(min(box))
        box[max_index], box[min_index] = box[max_index] - 1, box[min_index] + 1
    answer = max(box) - min(box)
    print(f"#{t} {answer}")