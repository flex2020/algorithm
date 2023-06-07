import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        
        for (int i=0; i<t.length() - pLen + 1; i++) {
            String subT = t.substring(i, i + pLen);
            if (Long.parseLong(subT) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        
        return answer;
    }
}