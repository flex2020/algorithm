import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> glory = new ArrayList<>();
        
        for (int i=0; i<score.length; i++) {
            if (i < k) {
                glory.add(score[i]);
                Collections.sort(glory);
            } else if (glory.get(0) < score[i]) {
                glory.set(0, score[i]);
                Collections.sort(glory);
            }
            answer[i] = glory.get(0);
        }
        
        return answer;
    }
}