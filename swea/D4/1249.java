package swea_d4;

import java.util.*;
import java.awt.Point;

public class P1249 {
	private static int[][] graph, visited;
	private static int N, answer;
	private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	private static final int INF = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			sc.nextLine();
			graph = new int[N][N];
			visited = new int[N][N];
			
			
			for (int i=0; i<N; i++) {
				String line = sc.nextLine();
				for (int j=0; j<N; j++) {
					graph[i][j] = line.charAt(j) - '0';
				}
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					visited[i][j] = INF;
				}
			}
			bfs();
			answer = visited[N-1][N-1];
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		visited[0][0] = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.x == N-1 && p.y == N-1) {
				continue;
			}
			
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (visited[p.x][p.y] + graph[nx][ny] < visited[nx][ny]) {
						q.add(new Point(nx, ny));
						visited[nx][ny] = visited[p.x][p.y] + graph[nx][ny];
					}
				}
			}
		}
	}
}
