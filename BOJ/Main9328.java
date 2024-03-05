package boj;

import java.io.*;
import java.util.*;

public class Main9328 {
	private static int h, w, key, answer;
	private static char[][] map;
	private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			answer = 0;
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			for (int i=0; i<h+2; i++) Arrays.fill(map[i], '.');
			for (int i=1; i<=h; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j=1; j<=w; j++) {
					map[i][j] = input[j-1];
				}
			}
			key = 0;
			String keyInput = br.readLine();
			for (int i=0; i<keyInput.length(); i++) {
				int keyIndex = keyInput.charAt(i) - 'a';
				key |= (1 << keyIndex);
			}
			bfs();
			System.out.println(answer);
		}
	}
	
	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0));
		boolean[][] visited = new boolean[h+2][w+2];
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || nx >= h+2 || ny < 0 || ny >= w+2 || map[nx][ny] == '*' || visited[nx][ny]) continue;
				if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z' && !hasKey(key, map[nx][ny])) {
					continue;
				}
				if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z' && !hasKey(key, (char)(map[nx][ny] - 32))) {
					visited = new boolean[h+2][w+2];
					q.clear();
					q.offer(new Point(0, 0));
					visited[0][0] = true;
					answer = 0;
					key |= (1 << (map[nx][ny] - 'a'));
				} else {
					if (map[nx][ny] == '$') answer += 1;
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
				}
			}
		}
		
	}
	
	private static boolean hasKey(int key, char door) {
		int doorIndex = door - 'A';
		return (key & (1 << doorIndex)) != 0;
	}
}
