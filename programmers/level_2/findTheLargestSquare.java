class Solution {
    public int solution(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int max = 0;
        
        if (m == 1) {
            for (int i=0; i<n; i++) {
                if (max < board[0][i]) {
                    max = board[0][i];
                }
            }
        }
        
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                int min = Math.min(Math.min(board[i-1][j-1], board[i-1][j]), board[i][j-1]);
                
                if (board[i][j] != 0) {
                    board[i][j] = min + 1;
                    if (max < min + 1) {
                        max = min + 1;
                    }
                }
            }
        }
        
        return max * max;
    }
}