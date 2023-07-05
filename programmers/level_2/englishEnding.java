import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> usedWords = new ArrayList<>();
        char last = words[0].charAt(0);
        for (int i=0; i<words.length; i++) {
            if (usedWords.contains(words[i])
               || last != words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            } else {
                last = words[i].charAt(words[i].length() - 1);
                usedWords.add(words[i]);
            }
        }
        return answer;
    }
}