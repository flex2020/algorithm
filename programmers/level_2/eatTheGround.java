class Solution {
    int solution(int[][] land) {
        int[][] DP = new int[100001][5];
        int height = land.length;
        
        for (int i=1; i<=height; i++) {
            DP[i][1] = Math.max(Math.max(DP[i-1][2] + land[i-1][0], DP[i-1][3] + land[i-1][0]), DP[i-1][4] + land[i-1][0]);
            DP[i][2] = Math.max(Math.max(DP[i-1][1] + land[i-1][1], DP[i-1][3] + land[i-1][1]), DP[i-1][4] + land[i-1][1]);
            DP[i][3] = Math.max(Math.max(DP[i-1][1] + land[i-1][2], DP[i-1][2] + land[i-1][2]), DP[i-1][4] + land[i-1][2]);
            DP[i][4] = Math.max(Math.max(DP[i-1][1] + land[i-1][3], DP[i-1][2] + land[i-1][3]), DP[i-1][3] + land[i-1][3]);
        }
        
        int answer = 0;
        for (int i=1; i<=4; i++) {
            if (answer < DP[height][i]) answer = DP[height][i];
        }
        return answer;
    }
}