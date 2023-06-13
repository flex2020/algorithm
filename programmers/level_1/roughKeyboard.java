class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] minCounts = new int[26];
        for (int i=0; i<26; i++) minCounts[i] = 9999;
        
        for (int i=0; i<keymap.length; i++) {
            String curKeymap = keymap[i];
            for (int j=0; j<curKeymap.length(); j++) {
                int index = curKeymap.charAt(j) - 'A';
                if (minCounts[index] > j) {
                    minCounts[index] = j+1;
                }
            }
        } 
        
        for (int i=0; i<targets.length; i++) {
            String target = targets[i];
            for (int j=0; j<target.length(); j++) {
                if (minCounts[target.charAt(j) - 'A'] == 9999) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += minCounts[target.charAt(j) - 'A'];
            }
        }
        
        return answer;
    }
}