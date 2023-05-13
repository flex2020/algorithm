class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // n: 빈 병의 수
        // 빈 병 a개 -> 콜라 b개
        
        while (n >= a) {
            n -= a;
            n += b;
            answer += b;
        }

        return answer;
    }
}