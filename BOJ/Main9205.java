package boj;

import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main9205 {
	private static int N;
	private static Point[] points;
	private static String answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = "sad";
			points = new Point[N+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			points[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			points[N+1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			bfs();
			System.out.println(answer);
		}
	}
	
	private static void bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(points[0].x, points[0].y));
		boolean[] visited = new boolean[N+2];
		visited[0] = true;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.x == points[N+1].x && p.y == points[N+1].y) {
				answer = "happy";
				return;
			}
			
			for (int i=N+1; i>=1; i--) {
				if (visited[i] || getDistance(points[i], p) > 1000) continue;
				q.offer(new Point(points[i].x, points[i].y));
				visited[i] = true;
			}
		}
	}
	
	private static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
