package boj;

import java.io.*;
import java.util.*;

public class Main11726 {
	private static int N;
	private static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp[1] = 1;
		if (N >= 2) dp[2] = 2;
		for (int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] % 10007 + dp[i-2] % 10007) % 10007;
		}
		System.out.println(dp[N]);
	}

}
