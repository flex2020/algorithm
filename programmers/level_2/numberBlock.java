class Solution {
    public int getMaxMeasure(int number) {
        if (number == 1) return 0;
        
        int measure = 1;
        for (int i=1; i*i<=number; i++) {
            if (i != 1 && number % i == 0) {
                if (number / i <= 10000000 && measure < number / i) measure = number / i;
                else if (measure < i) measure = i;
            }
        }
        return measure;
    }
    
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        
        for (int i=0, number=(int)begin; i<answer.length; i++, number++) {
            answer[i] = getMaxMeasure(number);
        }
        
        return answer;
    }
}