class Solution {
    // 제곱
    public int square(int n) {
        return n * n;
    }
    // 세제곱
    public int cubic(int n) {
        return n * n * n;
    }
    public int solution(String dartResult) {
        int answer = 0;
        int prevScore = 0;
        String number = "";
        for (int i=0; i<dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c >= '0' && c <= '9') {
                number += c;
            } else if (c == 'S' || c == 'D' || c == 'T') {
                char nextC = '?';
                if (i + 1 <= dartResult.length() - 1) {
                    nextC = dartResult.charAt(i + 1);
                }
                int score = 0;
                int temp = 0;
                if (c == 'S') {
                    score = Integer.parseInt(number);
                } else if (c == 'D') {
                    score = square(Integer.parseInt(number));
                } else if (c == 'T') {
                    score = cubic(Integer.parseInt(number));
                }
                if (nextC == '#') {
                    score = -score;
                } else if (nextC == '*') {
                    temp = 2 * score;
                    score = 2 * score + prevScore;
                }
                answer += score;
                number = "";
                prevScore = (nextC == '*') ? temp : score;
            }
        }
        return answer;
    }
}