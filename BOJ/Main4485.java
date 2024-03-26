package boj;

import java.io.*;
import java.util.*;

public class Main4485 {
	private static int N, answer;
	private static int[][] map;
	private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static class Point {
		int x, y, val;
		public Point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			map = new int[N][N];
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra();
			System.out.println("Problem " + (tc++) + ": " + answer);
		}
		
	}
	private static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);
		pq.offer(new Point(0, 0, map[0][0]));
		boolean[][] visited = new boolean[N][N];
		
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			
			if (p.x == N-1 && p.y == N-1) {
				answer = p.val;
				return;
			}
			
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				pq.offer(new Point(nx, ny, map[nx][ny] + p.val));
			}
		}
	}
}
