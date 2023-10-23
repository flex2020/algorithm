## 실전문제: 팀 결성
import sys
input = sys.stdin.readline

def find_team(team, a):
  if team[a] != a:
    team[a] = find_team(team, team[a])
  return team[a]

def union_team(team, a, b):
  a = find_team(team, a)
  b = find_team(team, b)

  if a < b:
    team[b] = a
  else:
    team[a] = b


N, M = map(int, input().split())
team = [0] * (N + 1)

# 각자 자기 팀으로 설정
for i in range(N + 1):
  team[i] = i

for _ in range(M):
  op, a, b = map(int, input().split())
  # 팀 합치기
  if op == 0:
    union_team(team, a, b)
  # 같은 팀 여부 확인
  elif op == 1:
    team_a = find_team(team, a)
    team_b = find_team(team, b)
    if team_a == team_b:
      print("YES")
    else:
      print("NO")