def dfs(list_num, count):
    global answer
    if count == n:
        snum = ''
        for s in list_num:
            snum += s
        answer = max(answer, int(snum))
        return
    
    for i in range(length):
        for j in range(i+1, length):
            list_num[i], list_num[j] = list_num[j], list_num[i]
            dfs(list_num, count + 1)
            list_num[i], list_num[j] = list_num[j], list_num[i]
   
        
T = int(input())
for t in range(1, T + 1):
    number, n = map(int, input().split())
    answer = 0
    list_num = list(str(number))
    length = len(list_num)
    dfs(list_num, 0)
    
    print(f"#{t} {answer}")