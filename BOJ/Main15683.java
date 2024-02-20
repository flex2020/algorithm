package boj;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main15683 {
	private static int N, M, answer;
	private static int[][] map, tempMap;
	private static List<Point> cctvs;
	private static List<Integer> dirs;
	private static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dirs = new ArrayList<>();
		cctvs = new ArrayList<>();
		map = new int[N][M];
		tempMap = new int[N][M];
		answer = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] < 5) cctvs.add(new Point(i, j));
			}
		}
		combination(0);
		System.out.println(answer);
	}
	
	private static void combination(int depth) {
		if (depth == cctvs.size()) {
			// 현재 방향으로 시뮬레이션 ㄱㄱ
			copyMap();
			simulate();
			int count = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (tempMap[i][j] == 0) count += 1;
				}
			}
			answer = Math.min(answer, count);		
			return;
		}
		
		for (int i=0; i<4; i++) {
			dirs.add(i);
			combination(depth + 1);
			dirs.remove(depth);
		}
	}
	
	private static void copyMap() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
	}
	
	private static void simulate() {
		// 각 cctv 별로 tempMap 설정해보기
		// 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
		for (int i=0; i<cctvs.size(); i++) {
			Point cctv = cctvs.get(i);
			int dir = dirs.get(i);
			// 일단 dir 방향으로 최대한 뻗어나간다
			markMap(cctv.x, cctv.y, dir);
			
			// cctv 타입에 따라서 추가적인 방향도 시작
			if (tempMap[cctv.x][cctv.y] == 2) {
				// 현재 방향과 반대방향으로
				dir = (dirs.get(i) + 2) % 4;
				markMap(cctv.x, cctv.y, dir);
			} else if (tempMap[cctv.x][cctv.y] == 3) {
				dir = (dirs.get(i) + 1) % 4;
				markMap(cctv.x, cctv.y, dir);
			} else if (tempMap[cctv.x][cctv.y] == 4) {
				dir = (dirs.get(i) + 3) % 4;
				markMap(cctv.x, cctv.y, dir);
				dir = (dirs.get(i) + 1) % 4;
				markMap(cctv.x, cctv.y, dir);
			}
		}
		// 타입 5 cctv 감시구역 마킹하기
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (tempMap[i][j] == 5) {
					for (int d=0; d<4; d++) {
						markMap(i, j, d);
					}
				}
			}
		}
	}
	
	private static void markMap(int x, int y, int dir) {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			// 끝까지 가면 루프 탈출
			if (nx < 0 || nx >= N || ny < 0 || ny >= M || tempMap[nx][ny] == 6) break;
			if (tempMap[nx][ny] == 0) tempMap[nx][ny] = 9; // 빈칸인 경우만 감시구역 9로 표기
		}
	}
}
