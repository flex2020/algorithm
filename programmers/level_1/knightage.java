import java.util.*;

class Solution {
    public int getDivisorsCount(int number) {
        int count = 0;
        for (int i=1; i*i<=number; i++) {
            if (i * i == number) count++;
            else if (number % i == 0) count += 2;
        }
        return count;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i=1; i<=number; i++) {
            int count = getDivisorsCount(i);
            answer += count > limit ? power : count;
        }
        
        return answer;
    }
}