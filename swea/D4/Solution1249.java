package swea;

import java.io.*;
import java.util.*;

public class Solution1249 {
	private static int N, answer;
	private static int[][] map;
	private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static class Point implements Comparable<Point> {
		int x, y, time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return time - o.time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String input = br.readLine();
				for (int j=0; j<N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			dijkstra();
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}
	
	private static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0, 0, map[0][0]));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			
			if (p.x == N-1 && p.y == N-1) {
				answer = p.time;
				return;
			}
			
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				pq.offer(new Point(nx, ny, p.time + map[nx][ny]));
				visited[nx][ny] = true;
			}
		}
	}
}
