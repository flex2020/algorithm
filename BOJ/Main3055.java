import java.util.*;
import java.io.*;

public class Main3055 {
    private static int R, C, startX, startY, answer;
    private static char[][] map;
    private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    
    static class Point {
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
    
    // . 비어있음, *: 물,  X: 돌, D: 비버(도착), S: 고슴도치(시작)
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j=0; j<C; j++) {
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }
        answer = -1;
        bfs();
        System.out.println(answer == -1 ? "KAKTUS" : answer);
    }
    
    private static void spreadWater() {
        List<Point> points = new ArrayList<>();
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] != '*') continue;
                for (int d=0; d<4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == 'D' || map[nx][ny] == 'X') continue;
                    points.add(new Point(nx, ny));
                }
            }
        }
        for (Point p : points) {
            map[p.x][p.y] = '*';
        }
    }

    // 고슴도치 bfs
    private static void bfs() {
        Queue<Point> q = new ArrayDeque<>(); // 고슴도치
        q.offer(new Point(startX, startY));
        boolean[][] visited = new boolean[R][C];
        visited[startX][startY] = true;
        int time = 0;
        while (!q.isEmpty()) {
            // 물을 뿌린 후 이동
            spreadWater();
            int qsize = q.size();
            for (int i=0; i<qsize; i++) {
                Point p = q.poll();
                // 도착하면 끝
                if (map[p.x][p.y] == 'D') {
                    answer = time;
                    return;
                }
                
                for (int d=0; d<4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
                
            }
            time += 1;
        }
    }
}
