package boj;

import java.io.*;
import java.util.*;

public class Main9095 {
	private static int N;
	private static int[] dp;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i=4; i<=10; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}
