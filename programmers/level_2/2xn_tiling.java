class Solution {
    private static int[] DP;
    private static int N;
    
    public int solution(int n) {
        int largeNumber = 1000000007;
        N = n;
        DP = new int[N + 1];
        DP[1] = 1;
        DP[2] = 2;
        for (int i=3; i<=N; i++) {
            DP[i] = ((DP[i-1] % largeNumber) + (DP[i-2] % largeNumber)) % largeNumber ;
        }
        
        
        return DP[n];
    }
}