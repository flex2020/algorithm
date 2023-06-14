import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> board2 = new ArrayList<>();
        Stack<Integer> basket = new Stack<>();
        
        // 스택에 담기
        for (int i=0; i<board[0].length; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j=board.length - 1; j>=0; j--) {
                if (board[j][i] != 0) {
                    s.push(board[j][i]);
                }
            }
            board2.add(s);
        }
        
        for (int i=0; i<moves.length; i++) {
            int index = moves[i];
            int top = -1;
            if (!board2.get(index-1).empty()) {
                top = board2.get(index - 1).peek();
                board2.get(index - 1).pop();
            }
            if (!basket.empty() && basket.peek() == top) {
                basket.pop();
                answer++;
            } else if (top != -1) {
                basket.push(top);
            }
        }
        //System.out.println(basket);
        return answer * 2;
    }
}