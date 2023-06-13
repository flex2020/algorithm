class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        // n: 벽의 길이, m: 롤러의 길이, section: 칠해야하는 곳
        
        // 1번만 칠하면 되는 경우
        if (section[section.length - 1] - section[0] + 1 <= m) return 1;
        
        // 최소 2번이상 칠해야하는 경우
        int start = section[0];
        int end = section[0] + m - 1;
        answer = 1;
        for (int i=0; i<section.length; i++) {
            // 롤러가 다시 시작하는 지점
            //System.out.println("section " + section[i] + " - start: " + start + " / end: " + end);
            if (end < section[i]) {
                start = section[i];
                end = section[i] + m - 1;
                answer++;
            }
            
        }
        
        
        return answer;
    }
}