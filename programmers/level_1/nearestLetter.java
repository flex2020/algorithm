import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                          'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<26; i++) {
            map.put(alphabets[i], -1);
        }
        
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (map.get(c) == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(c);
            }
            map.put(c, i);
        }
        
        return answer;
    }
}