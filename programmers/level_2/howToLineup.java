import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        // stream으로 사용했더니 시간 초과..
        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            numbers.add(i);
        }
        
        long fact = 1;
        for (int i=n; i>=2; i--) {
            fact *= i;
        }
        
        k -= 1; // 1번부터가 아닌 0번부터이기 때문에 k - 1
        long index = 0;
        int i = 0;
        while(i < n) {
            fact /= n - i;
            answer[i++] = numbers.remove((int) (k/fact));
            k %= fact;
        }
        
        return answer;
    }
}