package boj;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main10026 {
	private static int N, answer1, answer2;
	private static char[][] grid1, grid2;
	private static boolean[][] visited;
	private static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid1 = new char[N][N];
		grid2 = new char[N][N];
		visited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			grid1[i] = br.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				grid2[i][j] = grid1[i][j] == 'B' ? 'B' : 'R';
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, grid1);
					answer1 += 1;
				}
			}
		}
		visited = new boolean[N][N];
		
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j]) {
					bfs(i, j, grid2);
					answer2 += 1;
				}
			}
		}
		
		System.out.println(answer1 + " " + answer2);
	}
	
	private static void bfs(int startX, int startY, char[][] grid) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(startX, startY));
		visited[startX][startY] = true;
		char color = grid[startX][startY];
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || grid[nx][ny] != color) continue;
				visited[nx][ny] = true;
				q.offer(new Point(nx, ny));
			}
		}
	}
}
