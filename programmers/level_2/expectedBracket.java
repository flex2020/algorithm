class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (true) {
            answer++;
            if (a - b == -1 && a % 2 == 1) {
                break;   
            }
            a = (a % 2 == 1) ? a / 2 + 1 : a / 2; 
            b = (b % 2 == 1) ? b / 2 + 1 : b / 2; 
        }
        
        return answer;
    }
}