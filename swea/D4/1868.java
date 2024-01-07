package swea_d4;

import java.util.*;
import java.awt.Point;

public class P1868 {
	private static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	private static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int N, answer;
	private static int[][] visited;
	private static char[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			answer = 0;
			N = sc.nextInt();
			sc.nextLine(); // 버퍼 비우기
			board = new char[N][N];
			visited = new int[N][N];
			for (int i=0; i<N; i++) {
				board[i] = sc.nextLine().toCharArray();
			}
			countMine();
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (visited[i][j] == 0 && board[i][j] == '.') {
						bfs(i, j);
						answer++;
					}
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (visited[i][j] > 0 && board[i][j] == '.') {
						answer++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}
	
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = -1;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i=0; i<8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (visited[nx][ny] != -1 && board[nx][ny] == '.') {
						if (visited[nx][ny] == 0) {
							q.add(new Point(nx, ny));
						}
						visited[nx][ny] = -1;
					}
				}
			}
		}
	}
	
	private static void countMine() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (board[i][j] == '.') {
					int count = 0;
					for (int d=0; d<8; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == '*') {
							count++;
						}
					}
					visited[i][j] = count;
				}
			}
		}
	}
}