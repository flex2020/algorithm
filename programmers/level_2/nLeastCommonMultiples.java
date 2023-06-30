class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int[] answerArr = new int[101];
        
        for(int i=0; i<arr.length; i++) {
            int number = arr[i];
            for (int j=2; j<=number; j++) {
                int count = 0;
                while (true) {
                    if (number % j != 0) break;
                    number /= j;
                    count++;
                }
                if (answerArr[j] < count) {
                    answerArr[j] = count;
                }
            }
        }
        
        for (int i=2; i<=100; i++) {
            if (answerArr[i] != 0) {
                for(int j=0; j<answerArr[i]; j++) {
                    answer *= i;
                }
            }
        }
        
        return answer;
    }
}