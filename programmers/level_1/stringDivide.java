class Solution {
    public int solution(String s) {
        if (s.length() == 1) return 1;
        int answer = 0;
        char target = s.charAt(0);
        int[] count = new int[2];
        count[0] = 1;
        count[1] = 0;
        for (int i=1; i<s.length(); i++) {
            if (count[0] == 0) {
                target = s.charAt(i);
            }
            if (target != s.charAt(i)) {
                count[1]++;
            } else {
                count[0]++;
            }
            if (count[0] == count[1]) {
                answer += 1;
                count[0] = 0;
                count[1] = 0;
            }
            if (i == s.length() - 1 && count[0] != count[1]) {
                answer += 1;
            }
        }
        return answer;
    }
}