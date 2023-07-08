/**
 * 테스트 케이스 9, 10, 11 런타임 오류로 실패한 풀이
 */
class Solution {
    public static int MAX = 1000000 + 1;
    public int[] dp;
    
    public int convert(int x, int y, int n, int count) {
        // 기존 연산 값이 있다면 MAX 반환
        if (dp[x] != 0 && dp[x] <= count) {
            return MAX;
        }
        dp[x] = count;
        if (x == y) {
            return count;
        }
        int v1 = MAX, v2 = MAX, v3 = MAX;
        if (x + n <= y) v1 = convert(x + n, y, n, count+1);
        if (x * 2 <= y) v2 = convert(x * 2, y, n, count+1);
        if (x * 3 <= y) v3 = convert(x * 3, y, n, count+1);
        
        return Math.min(v1, Math.min(v2, v3));
    }
    
    public int solution(int x, int y, int n) {
        dp = new int[MAX];
        int answer = convert(x, y, n, 0);

        return (answer >= MAX) ? -1 : answer;
    }
}