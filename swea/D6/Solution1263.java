package swea;

import java.io.*;
import java.util.*;

public class Solution1263 {
	private static int N;
	private static long answer;
	private static long[][] graph, dist;
	private static final int INF = 10000000;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			graph = new long[N][N];
			dist = new long[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (graph[i][j] == 0) dist[i][j] = INF;
					else dist[i][j] = 1;
				}
			}
				
			ggggggggggggggggggggggggooooooooooooooooooooooooo();
			for (int i=0; i<N; i++) {
				long sum = 0;
				for (int j=0; j<N; j++) {
					sum += dist[i][j];
				}
				answer = Math.min(answer, sum);
			}
			System.out.println("#" + tc + " " + (answer-2));
		}
		
	}
	private static void ggggggggggggggggggggggggooooooooooooooooooooooooo() {
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
