package boj;

import java.util.*;
import java.io.*;

public class Main17281 {
	private static int N, answer;
	private static int[][] results;
	private static boolean[] sel;
	private static List<Integer> battingOrder;
	
	static class Game {
		int inning, out, score, index;
		Queue<Integer> runner;
		public Game(int inning, int out, int score, int index) {
			super();
			this.inning = inning;
			this.out = out;
			this.score = score;
			this.index = index;
			runner = new ArrayDeque<>();
		}
		
		public void inningChange() {
			inning += 1;
			out = 0;
			runner = new ArrayDeque<>();
		}
		// n루타 처리
		public void baseHit(int n) {
			if (n == 0) {
				out += 1;
			}
			else {
				runner.offer(0);
				int qsize = runner.size();
				for (int i=0; i<qsize; i++) {
					int base = runner.poll();
					base += n;
					if (base < 4) runner.offer(base);
					else score += 1;
				}
			}
			index = (index + 1) % 9;
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		results = new int[N][9];
		sel = new boolean[9];
		battingOrder = new ArrayList<>();
		// 0: 아웃, 1: 안타, 2: 2루타, 3: 3루타, 4: 홈런
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				results[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permutation(0);
		System.out.println(answer);
	}
	
	
	// 1~8까지 순열
	private static void permutation(int idx) {
		// 8개 고르면 종료
		if (idx == 8) {
			// 타순 정했으니 시뮬레이션 ㄱㄱ
			battingOrder.add(3, 0);
			simulate();
			battingOrder.remove(3);
			return;
		}
		
		for (int i=1; i<9; i++) {
			if (sel[i]) continue;
			sel[i] = true;
			battingOrder.add(i);
			permutation(idx + 1);
			battingOrder.remove(idx);
			sel[i] = false;
		}
	}
	
	private static void simulate() {
		Game game = new Game(0, 0, 0, 0);
		// 정해진 타순으로 N이닝까지 야구 시작
		while (game.inning != N) {
			int batter = battingOrder.get(game.index);
			game.baseHit(results[game.inning][batter]);
			if (game.out == 3) game.inningChange();
		}
		
		// 최대 점수 갱신
		answer = Math.max(game.score, answer);
	}
}
