class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String bab: babbling) {
            bab = bab.replaceAll("ayaaya|yeye|woowoo|mama", "#");
            bab = bab.replaceAll("aya|ye|woo|ma", "");
            if (bab.equals("")) answer++;
        }
        
        return answer;
    }
}