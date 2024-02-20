package boj;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main2636 {
	private static int N, M, count, time, prevCount;
	private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	private static int[][] map, map2;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		map2 = new int[N][M];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) count += 1;
			}
		}
		simulate();
		System.out.println(time);
		System.out.println(prevCount);
	}
	
	private static void simulate() {
		while (count > 0) {
			time += 1;
			// 공기 2로 만들기
			setAir();
			// 지도에서 2와 인접한 치즈 녹이기
			meltDown();
		}
	}
	
	private static void meltDown() {
		prevCount = count;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (check(i, j)) {
					map[i][j] = 0;
					count -= 1;
				}
			}
		}
	}
	
	// (x,y)의 치즈가 녹을 수 있는지 확인하는 함수
	private static boolean check(int x, int y) {
		if (map2[x][y] != 1) return false;
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map2[nx][ny] != 2) continue;
			return true;
		}
		
		return false;
	}
	
	private static void bfs(int startX, int startY) {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(startX, startY));
		boolean[][] visited = new boolean[N][M];
		visited[startX][startY] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			map2[p.x][p.y] = 2;
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || visited[nx][ny]) continue;
				q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	private static void setAir() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map2[i][j] = map[i][j];
			}
		}
		bfs(0, 0);
	}
}
