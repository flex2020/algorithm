import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int count = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i=score.length-1; i>=0; i--) {
            count++;
            tempList.add(score[i]);
            if (count%m == 0) {
                int min = tempList.get(count-1);
                answer += min * m;
            }
        }
        
        return answer;
    }
}