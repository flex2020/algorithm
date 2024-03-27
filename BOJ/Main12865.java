package boj;

import java.io.*;
import java.util.*;

public class Main12865 {
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] items = new int[N][2]; // 무게, 가치 순
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[K+1];
		for (int i=0; i<N; i++) {
			int w = items[i][0];
			int v = items[i][1];
			for (int j=K; j>=1; j--) {
				if (j - w >= 0) {
					dp[j] = Math.max(dp[j], dp[j-w] + v);
				}
			}
		}
		System.out.println(dp[K]);
	}

}
