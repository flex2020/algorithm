class Solution {
    public long solution(int n) {
        long[] DP = new long[2001];
        
        DP[1] = 1;
        DP[2] = 2;
        
        for (int i=3; i<=n; i++) {
            DP[i] = ((DP[i-2] % 1234567) + (DP[i-1] % 1234567)) % 1234567;
        }
        
        return DP[n];
    }
}