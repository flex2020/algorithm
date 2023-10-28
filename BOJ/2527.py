for t in range(4):
  x1, y1, p1, q1, x2, y2, p2, q2 = map(int, input().split())
  
  xleft = max(x1, x2)
  xright = min(p1, p2)
  ybottom = max(y1, y2)
  ytop = min(q1, q2)

  # 사각형인 경우
  if xright - xleft > 0 and ytop - ybottom > 0:
    print('a')
  elif xleft == xright and ytop - ybottom > 0 or ytop == ybottom and xright - xleft > 0:
    print('b')
  elif (xleft, ybottom) == (xright, ytop):
    print('c')
  else:
    print('d')