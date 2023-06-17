class Solution {
    public static int answer = 0;
    public static int N;
    public static String[] conditions;
    
    public boolean check(StringBuilder permutation) {
        boolean result = true;
        char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        
        for (int i=0; i<N; i++) {
            char ch1 = conditions[i].charAt(0);
            char ch2 = conditions[i].charAt(2);
            char op = conditions[i].charAt(3);
            int distance = conditions[i].charAt(4) - '0';
            int index1 = permutation.indexOf("" + ch1);
            int index2 = permutation.indexOf("" + ch2);
            int abs = (index1 - index2 < 0) ? index2 - index1 - 1 : index1 - index2 - 1;
            
            if (op == '=') {
                result = result && (abs == distance);
            } else if (op == '>') {
                result = result && (abs > distance);
            } else {
                result = result && (abs < distance);
            }
            if (!result) return false;
        }
        return result;
    }
    
    public void dfs(StringBuilder tempPermutation, boolean[] used) {
        char[] characters = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        if (tempPermutation.length() == 8) {
            if (check(tempPermutation)) {
                answer += 1;
            }
            return;
        }

        for (int i=0; i<8; i++) {
            if (!used[i]) {
                used[i] = true;
                StringBuilder sb = new StringBuilder(tempPermutation.toString());
                dfs(sb.append(characters[i]), used);
                used[i] = false;
            }
        }
        
    }
    
    public int solution(int n, String[] data) {
        answer = 0;
        N = n;
        conditions = data;
        boolean[] used = {false, false, false, false, false, false, false, false};
        dfs(new StringBuilder(""), used);
        
        
        return answer;
    }
}