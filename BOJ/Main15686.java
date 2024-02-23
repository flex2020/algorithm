package boj;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main15686 {
	private static int N, M, answer;
	private static int[][] map;
	private static List<Point> chicken, house;
	private static boolean[] sel;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		chicken = new ArrayList<>();
		house = new ArrayList<>();
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) house.add(new Point(i, j));
				else if (map[i][j] == 2) chicken.add(new Point(i, j));
			}
		}
		sel = new boolean[chicken.size()];
		
		combination(0, 0);
		System.out.println(answer);
	}
	
	private static void combination(int idx, int cnt) {
		if (cnt == M) {
			// 뽑힌 치킨집들로 도시의 치킨 거리를 계산한다
			simulate();
			return;
		}
		if (idx == chicken.size()) {
			return;
		}
		
		// 고른다
		sel[idx] = true;
		combination(idx + 1, cnt + 1);
		
		// 고르지 않는다
		sel[idx] = false;
		combination(idx + 1, cnt);
	}
	
	private static void simulate() {
		int total = 0;
		// 모든 집을 돌면서
		for (int i=0; i<house.size(); i++) {
			// 현재 집과 가장 가까운 치킨거리를 구한다.
			int minDist = Integer.MAX_VALUE;
			Point h = house.get(i);
			for (int j=0; j<chicken.size(); j++) {
				if (!sel[j]) continue;
				Point c = chicken.get(j);
				minDist = Math.min(minDist, getDistance(h, c));
			}
			total += minDist;
		}
		answer = Math.min(answer, total);
	}
	
	private static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
