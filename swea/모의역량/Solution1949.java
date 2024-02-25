package swea;

import java.io.*;
import java.util.*;

public class Solution1949 {
	private static int N, K, answer;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			answer = 0;
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int maxHeight = 0;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == maxHeight) {
						visited = new boolean[N][N];
						dfs(i, j, 1, true);
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static void dfs(int x, int y, int dist, boolean canDigging) {
		//System.out.println("(" + x + ", " + y + "), dist = " + dist + ", canDigging = " + canDigging);
		answer = Math.max(answer, dist);
		visited[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] >= map[x][y] && !canDigging || map[nx][ny] - K >= map[x][y]) continue;
			
			// 그냥 갈 수 있는 경우
			if (map[x][y] > map[nx][ny]) dfs(nx, ny, dist + 1, canDigging);
			// 현재 땅이 다음 땅보다 낮지만 다음 땅을 파낼 수 있는 경우
			else if (map[x][y] >= map[nx][ny] - K && canDigging) {
				// 1 ~ K 깊이까지 다음 땅을 파보고 갈 수 있다면 가본다
				for (int k=1; k<=K; k++) {
					// 땅을 파내도 높이가 높거나 같다면 패스
					if (map[nx][ny] - k >= map[x][y]) continue;
					map[nx][ny] -= k;
					dfs(nx, ny, dist + 1, false);
					map[nx][ny] += k;
				}
			}
			visited[nx][ny] = false;
		}
	}
}
