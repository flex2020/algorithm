# 경로 압축 기법
def find_parent(parent, x):
  # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀 호출
  if parent[x] != x:
    parent[x] = find_parent(parent, parent[x])
  return parent[x]

# 두 원소가 속한 집합 합치기
def union_parent(parent, a, b):
  a = find_parent(parent, a)
  b = find_parent(parent, b)
  # 작은 노드를 부모로 설정
  if a < b:
    parent[b] = a
  else:
    parent[a] = b

# 노드의 개수와 간선 수 입력 받기
v, e = map(int, input().split())
parent = [0] * (v + 1)

# 부모 테이블에서 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
  parent[i] = i

# union 연산 수행
for i in range(e):
  a, b = map(int, input().split())
  union_parent(parent, a, b)

# 각 원소가 속한 집합 출력
for i in range(1, v + 1):
  print(f"{i}가 속한 집합: {find_parent(parent, i)}")
print()

# 부모 테이블 내용 출력
for i in range(1, v + 1):
  print(f"{i}의 부모: {parent[i]}")
