package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main16987 {
	private static int N, answer;
	private static Egg[] eggs;

	static class Egg {
		int durablility, weight;

		public Egg(int durablility, int weight) {
			super();
			this.durablility = durablility;
			this.weight = weight;
		}
		
		public boolean isBroken() {
			return this.durablility <= 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];

		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(d, w);
		}
		dfs(0);
		System.out.println(answer);
	}
	
	private static void dfs(int hand) {
		if (hand == N) {
			int count = 0;
			for (int i=0; i<N; i++) {
				if (eggs[i].isBroken()) count += 1; 
			}
			answer = Math.max(answer, count);
			return;
		}
		if (eggs[hand].isBroken() || check(hand)) {
			dfs(hand + 1);
			return;
		}
		
		// 깨지지 않는 다른 계란을 다 쳐본다
		for (int i=0; i<N; i++) {
			// 손에 든 계란이 아닌 것 중 깨진 것은 패스
			if (i == hand || eggs[i].isBroken()) continue;
			eggs[hand].durablility -= eggs[i].weight;
			eggs[i].durablility -= eggs[hand].weight;
			dfs(hand + 1);
			eggs[hand].durablility += eggs[i].weight;
			eggs[i].durablility += eggs[hand].weight;
		}
	}
	
	private static boolean check(int hand) {
		for (int i=0; i<N; i++) {
			if (i != hand && !eggs[i].isBroken()) return false;
		}
		return true;
	}
}
