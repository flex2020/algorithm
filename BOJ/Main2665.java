package boj;

import java.io.*;
import java.util.*;

public class Main2665 {
	private static int N, answer;
	private static char[][] map;
	private static int[][] dmap;
	private static final char BLACK = '0';
	private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static class Point implements Comparable<Point> {
		int x, y, cost;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		dmap = new int[N][N];
		answer = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) map[i] = br.readLine().toCharArray();
		
		// BFS 방식
		//bfs();
		
		// 다익스트라 방식
		dijkstra();
		
		System.out.println(answer);
	}
	
	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0));
		int[][] visited = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		visited[0][0] = 0;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.x == N-1 && p.y == N-1) {
				answer = Math.min(answer, visited[N-1][N-1]);
				continue;
			}
			
			// 사방탐색
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				// 지도 범위를 벗어난다면 패스
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				// 만약 검은방이고 비용이 갱신된다면 간다
				if (map[nx][ny] == BLACK) {
					if (visited[nx][ny] > visited[p.x][p.y] + 1) {
						q.offer(new Point(nx, ny));
						visited[nx][ny] = visited[p.x][p.y] + 1;
					}
				}
				// 흰방이고 비용 갱신이 되면 간다
				else {
					if (visited[nx][ny] > visited[p.x][p.y]) {
						q.offer(new Point(nx, ny));
						visited[nx][ny] = visited[p.x][p.y];
					}
				}
			}
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>(); // cost가 높은 것이 먼저 빠져나옴
		pq.offer(new Point(0, 0, 0));
		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;
		
		while (!pq.isEmpty()) {
			Point p = pq.poll();
			
			if (p.x == N-1 && p.y == N-1) {
				answer = p.cost;
				return;
			}
			
			// 사방탐색
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				// 지도 범위를 벗어난다면 패스
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				// 검은방 갈때
				if (map[nx][ny] == BLACK) pq.offer(new Point(nx, ny, p.cost + 1));
				else pq.offer(new Point(nx, ny, p.cost));
				visited[nx][ny] = true;
			}
		}	
	}
}
