package swea;

import java.util.*;
import java.io.*;

public class Solution5643 {
	private static int N, M, answer, smaller, taller;
	private static int[][] graph;
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			answer = 0;
			graph = new int[N+1][N+1];
			for (int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
			}
			for (int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				smaller = 0;
				taller = 0;
				smalldfs(i);
				talldfs(i);
				smaller -= 1;
				taller -= 1;
				
				if (smaller + taller == N-1) answer += 1;
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void smalldfs(int x) {
		smaller += 1;
		visited[x] = true;
		for (int i=1; i<=N; i++) {
			if (graph[i][x] == 1 && !visited[i]) smalldfs(i);
		}
	}
	
	private static void talldfs(int x) {
		taller += 1;
		visited[x] = true;
		for (int i=1; i<=N; i++) {
			if (graph[x][i] == 1 && !visited[i]) talldfs(i);
		}
	}
}
