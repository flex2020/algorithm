T = int(input())

for tc in range(1, T + 1):
  answer = 0
  data = input()
  clap_people = 0
  if data[0] == '0': 
    answer += 1
    clap_people = 1
  else: clap_people += int(data[0])

  for i in range(1, len(data)):
    if data[i] == '0': continue
    if clap_people < i:
      answer += i - clap_people
      clap_people += i - clap_people
    clap_people += int(data[i])
  print(f"#{tc} {answer}")