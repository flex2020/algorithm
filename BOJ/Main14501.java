package boj;

import java.io.*;
import java.util.*;

public class Main14501 {
	private static int N;
	private static int[] dp;
	private static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		arr = new int[N+1][2];
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i][1];
		}
		
		for (int i=2; i<=N; i++) {
			for (int j=1; j<i; j++) {
				if (j + arr[j][0] <= i) {
					dp[i] = Math.max(arr[i][1] + dp[j], dp[i]);
				}
			}
		}
		
		int answer = 0;
		for (int i=1; i<=N; i++) {
			if (i + arr[i][0] - 1 <= N) {
				answer = Math.max(dp[i], answer);
			}
		}
		
		System.out.println(answer);
	}

}
