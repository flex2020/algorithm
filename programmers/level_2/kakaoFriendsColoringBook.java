import java.util.*;

// DFS를 활용한 풀이
class Solution {
    public static int numberOfArea = 0;
    public static int maxSizeOfOneArea = 0;
    public static int area = 0;
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    public static void dfs(int x, int y, int[][] picture, boolean[][] visited) {
        // 방문 확인
        if (visited[x][y]) return;
        
        // 아래부터는 첫 방문한 좌표의 경우
        visited[x][y] = true;
        area += 1;
        int size_x = picture.length;
        int size_y = picture[0].length;
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                
                // picture 바깥은 갈 수 없음
                if (next_x < 0 || next_y < 0 || next_x >= size_x || next_y >= size_y) {
                    continue;
                }
                // 현재 색과 같은 색이면서 방문한 적 없을 경우 다음 좌표도 탐색
                if (picture[x][y] == picture[next_x][next_y] && !visited[next_x][next_y]) {
                    dfs(next_x, next_y, picture, visited);
                }
            }
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                visited[i][j] = false;
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                // 방문 한적 없는 좌표이면서 색이 0이 아닌 경우만 탐색
                if (!visited[i][j] && picture[i][j] != 0){
                    // 탐색한 영역의 수 증가
                    numberOfArea += 1;
                    dfs(i, j, picture, visited);
                } 
                // 가장 큰 영역 갱신
                if (area > maxSizeOfOneArea) {
                    maxSizeOfOneArea = area;
                }
                area = 0;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    

}