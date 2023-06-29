import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder("");
        int len = s.length();
        boolean flag = true; // 현재 대문자를 쓸 수 있는지 
        
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (flag && c != ' ') {
                flag = false;
                // 현재 문자가 소문자라면 대문자로 변환
                if (c >= 'a' && c <= 'z') c -= 32;
            }
            else if (!flag) {
                if (c == ' ') flag = true;
                else if (c >= 'A' && c <= 'Z') c += 32;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}