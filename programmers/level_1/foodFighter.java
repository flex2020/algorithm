class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("");
        
        for (int i=1; i<food.length; i++) {
            int cur = (int)food[i]/2;
            for (int j=0; j<cur; j++) {
                sb.append(i);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        sb.append("0");
        sb2.append(sb.reverse());
        return sb2.toString();
    }
}