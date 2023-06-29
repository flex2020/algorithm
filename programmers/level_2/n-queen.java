class Solution {
    public static int[] board;
    public static int answer;
    
    public void dfs(int n, int curRow) {
        // 종료 조건 - row(현재 행)와 n(행의 수)가 같게 될 때 성공
        if (curRow == n) {
            answer++;
            return;
        }
        
        for (int i=0; i<n; i++) {
            board[curRow] = i; // (curRow, i)에 퀸을 배치
            // 퀸을 배치할 수 있는 곳인지 확인
            if (check(curRow)) {
                dfs(n, curRow + 1); // 배치할 수 있다면 이 후의 과정 전개
            }
        }
    }
    
    public boolean check(int curRow) {
        // 현재 행까지 보드판을 확인
        for (int i=0; i<curRow; i++) {
            // 같은 열이면 안됨, 대각선이면 안됨
            if (board[i] == board[curRow] || curRow - i == Math.abs(board[curRow] - board[i])) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n) {
        board = new int[n];
        answer = 0;
        
        dfs(n, 0);
        
        return answer;
    }
}