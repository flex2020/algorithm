import java.util.*;
class Solution {
    public static List<int[]> list;
    public static void hanoi(int n, int from, int to, int sub) {
        int[] cur = new int[2];
        if (n == 1) {
            cur[0] = from;
            cur[1] = to;
            list.add(cur);
            return;
        }
        hanoi(n-1, from, sub, to);
        cur[0] = from;
        cur[1] = to;
        list.add(cur);
        hanoi(n-1, sub, to, from);
    }
    
    public int[][] solution(int n) {
        list = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        int[][] answer = new int[list.size()][];
        return list.toArray(answer);
    }
}