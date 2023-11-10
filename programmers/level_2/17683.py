def get_time_diff(start, end):
    start_hour, start_minute = start.split(':')
    end_hour, end_minute = end.split(':')
    hour_diff = int(end_hour) - int(start_hour)
    if end_hour == start_hour:
        return int(end_minute) - int(start_minute)
    else:
        return int(end_minute) - int(start_minute) + 60 * hour_diff

def get_melody_list(melody):
    mlist = []
    for i in range(len(melody)-1):
        if melody[i] != '#':
            if melody[i+1] == '#':
                mel = melody[i:i+2]
            else:
                mel = melody[i]
            mlist.append(mel)
    if melody[-1] != '#':
        mlist.append(melody[-1])
    
    return mlist

hashing = {
    'C': 'a',
    'C#': 'b',
    'D': 'c',
    'D#': 'd',
    'E': 'e',
    'F': 'f',
    'F#': 'g',
    'G': 'h',
    'G#': 'i',
    'A': 'j',
    'A#': 'k',
    'B': 'l',
    'E#': 'm'
}
    
def solution(m, musicinfos):
    answer = ''
    music = []
    for i in range(len(musicinfos)):
        start, end, title, melody = musicinfos[i].split(',')
        time_diff = get_time_diff(start, end)
        melody_list = get_melody_list(melody)
        m_list = get_melody_list(m)
        hashed_melody = ''
        hashed_m = ''
        play_melody = []
        cnt = 0
        while cnt < time_diff:
            play_melody.append(melody_list[cnt % len(melody_list)])
            cnt += 1
            
        for mel in play_melody:
            hashed_melody += hashing[mel]
        for mel in m_list:
            hashed_m += hashing[mel]
        
        
        # 안뒤집어도 나옴
        if hashed_m in hashed_melody:
            music.append((time_diff, -i, title))
            continue
        
    
    music.sort(reverse=True)
    if music:
        answer = music[0][2]
    else:
        answer = '(None)'
    return answer