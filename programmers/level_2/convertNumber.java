import java.util.*;
class Solution {
    public static int MAX = 1000000 + 1;
    public int[] dp;
    
    public int solution(int x, int y, int n) {
        dp = new int[MAX];
        Arrays.fill(dp, -1);
        dp[x] = 0;
        // i = 현재의 x
        for (int i=x; i<=y; i++) {
            // 만약 기존에 연산한 dp 값이 있다면
            if (dp[i] != -1) {
                // (현재의 x) + n 으로 변환한 적이 없다면
                if (i + n <= y) {
                    if (dp[i+n] == -1) {
                        dp[i+n] = dp[i] + 1; // 연산횟수 추가
                    } else {
                        dp[i+n] = Math.min(dp[i] + 1, dp[i+n]);
                    }
                }
                if (i * 2 <= y) {
                    if (dp[i*2] == -1) {
                        dp[i*2] = dp[i] + 1;  
                    } else {
                        dp[i*2] = Math.min(dp[i] + 1, dp[i*2]);
                    }
                } 
                if (i * 3 <= y) {
                    if (dp[i*3] == -1) {
                        dp[i*3] = dp[i] + 1;  
                    } else {
                        dp[i*3] = Math.min(dp[i] + 1, dp[i*3]);
                    }
                }
            }
        }
        return dp[y];
    }
}