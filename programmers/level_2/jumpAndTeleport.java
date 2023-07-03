import java.util.*;

public class Solution {
    public boolean isPrime(int n) {
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
    public int solution(int n) {
        int ans = 0;
        int position = 0;
        while (n % 2 == 0) {
            n /= 2;
        }
        if (n == 1) return 1;
        // n은 3이상의 홀수
        while(n != 1) {
            if (n % 2 != 0) {
                n--;
                ans++;
            }
            n /= 2;
        }
        
        
        return ans + 1;
    }
}