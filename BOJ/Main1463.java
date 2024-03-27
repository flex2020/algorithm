package boj;

import java.io.*;
import java.util.*;

public class Main1463 {
	private static int N;
	private static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// dp[i] : 1 -> i 연산 횟수
		dp = new int[N+1];
		dp[1] = 0;
		for (int i=2; i<=N; i++) {
			int v2 = Integer.MAX_VALUE, v3 = Integer.MAX_VALUE;
			int v1 = dp[i-1] + 1; // 이전에서 +1
			if (i % 2 == 0) v2 = dp[i/2] + 1; // 이전에서 *2
			if (i % 3 == 0) v3 = dp[i/3] + 1; // 이전에서 *3
			dp[i] = Math.min(v1, Math.min(v2, v3));
		}
		System.out.println(dp[N]);
	}

}
