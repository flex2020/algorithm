T = int(input())

for i in range(1, T + 1) :
    p, q, r, s, w = map(int, input().split())
    a, b = 0, 0
    a += w * p
    b += q
    if w > r :
        b += (w - r) * s

    print('#%d %d' % (i, min(a, b)))