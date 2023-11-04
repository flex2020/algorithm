def solution(sequence, k):
    answer = []
    start = 0
    end = 0
    total = sequence[0]
    while start <= end:
        if start < 0 or start >= len(sequence) or end < 0 or end >= len(sequence):
            break
        if total == k:
            if not answer:
                answer = [start, end]
            else:
                len1 = answer[1] - answer[0]
                len2 = end - start
                if len1 > len2:
                    answer = [start, end]
                elif len1 == len2:
                    answer = [min(answer[0], start), min(answer[1], end)]
            start += 1
            end += 1
            if 0 <= start - 1 < len(sequence) and 0 <= end < len(sequence):
                total -= sequence[start-1]
                total += sequence[end]
        elif total < k:
            end += 1
            if 0 <= end < len(sequence):
                total += sequence[end]
        else:
            start += 1
            if 0 <= start - 1 < len(sequence):
                total -= sequence[start-1]
            
    return answer