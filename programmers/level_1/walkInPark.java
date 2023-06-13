class Solution {
    class Position {
        String[] park;
        public int x;
        public int y;
        
        public void display() {
            System.out.println("x: " + x + ", y: " + y);
        }
        
        public void move(String op) {
            String dir = op.split(" ")[0];
            int val = Integer.parseInt(op.split(" ")[1]);
            
            if (dir.equals("E")) {
                if (this.y + val < park[0].length()) {
                    String subString = park[x].substring(y, y + val + 1);
                    if (!subString.contains("X")) this.y += val;
                }
            } else if (dir.equals("W")) {
                if (this.y - val >= 0) {
                    String subString = park[x].substring(y - val, y);
                    if (!subString.contains("X")) this.y -= val;
                }
            } else if (dir.equals("N")) {
                if (this.x - val >= 0) {
                    int i = 1;
                    for (i=1; i<=val; i++) {
                        if (park[x - i].charAt(y) == 'X') {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1) {
                        this.x -= val;
                    }
                }
            } else if (dir.equals("S")) {
                if (this.x + val < park.length) {
                    int i = 1;
                    for (i=1; i<=val; i++) {
                        if (park[x + i].charAt(y) == 'X') {
                            i = -1;
                            break;
                        }
                    }
                    if (i != -1) {
                        this.x += val;
                    }
                }
            }
        }
    }
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        Position current = new Position();
        current.park = park;
        
        for (int i=0; i<park.length; i++) {
            if (park[i].contains("S")) {
                current.y = park[i].indexOf("S");
                current.x = i;
                break;
            }
        }
        
        for (int i=0; i<routes.length; i++) {
            current.move(routes[i]);
        }
        answer[0] = current.x;
        answer[1] = current.y;
        return answer;
    }
}