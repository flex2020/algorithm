package swea;

import java.io.*;
import java.util.*;

public class Solution7208 {
	private static int N, answer;
	private static int[] colors;
	private static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			colors = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				colors[i] = Integer.parseInt(st.nextToken());
			}
			graph = new int[N][N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			recursive(0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static boolean recursive(int idx, int count) {
		if (idx == N) {
			if (!check()) return false;
			answer = Math.min(answer, count);
			return true;
		}
		// 현재 바꿀 수 있는 색들을 찾아본다
		boolean[] unable = new boolean[5];
		unable[colors[idx]] = true;
		for (int next=0; next<N; next++) {
			if (graph[idx][next] == 1) {
				unable[colors[next]] = true;
				
			}
		}
		
		// 바꾸지 않아본다.
		if (recursive(idx + 1, count)) return true;
		
		// 인접한 국가와 색이 같은게 있다면 현재 색상을 바꿀 수 있는 거로 바꿔본다.
		for (int i=1; i<=4; i++) {
			if (unable[i]) continue;
			int prev = colors[idx];
			colors[idx] = i;
			if (recursive(idx + 1, count + 1)) return true;
			colors[idx] = prev;
		}
		return false;
	}
	private static boolean check() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (graph[i][j] == 0) continue;
				if (colors[i] == colors[j]) return false;
			}
		}
		return true;
	}
}
