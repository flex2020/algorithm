for _ in range(1, 11):
    t = int(input())
    sum_row = [0] * 100
    sum_col = [0] * 100
    dia1, dia2 = 0, 0
    for i in range(100):
        temp = list(map(int, input().split()))
        for j in range(100):
            sum_col[j] += temp[j]
            if i == j:
                dia1 += temp[j]
            elif i == 99 - j:
                dia2 += temp[j]
        sum_row[i] = sum(temp)
    answer = max(max(sum_row), max(sum_col), dia1, dia2)
    
    print(f"#{t} {answer}")