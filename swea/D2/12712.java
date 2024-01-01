package swea_d2;

import java.util.*;

public class P12712 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			int answer = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] board = new int[N][N];
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			for (int t=0; t<N; t++) {
				for (int k=0; k<N; k++) {
					int sum1 = board[t][k];
					// 위
					for (int i=1; i<M; i++) {
						if (t - i < 0) break;
						sum1 += board[t-i][k];
					}
					// 아래
					for (int i=1; i<M; i++) {
						if (t + i >= N) break;
						sum1 += board[t+i][k];
					}
					// 왼쪽
					for (int i=1; i<M; i++) {
						if (k - i < 0) break;
						sum1 += board[t][k-i];
					}
					// 오른쪽
					for (int i=1; i<M; i++) {
						if (k + i >= N) break;
						sum1 += board[t][k+i];
					}
					answer = Math.max(answer, sum1);
					
					int sum2 = board[t][k];
					// 왼, 위
					for (int i=1; i<M; i++) {
						if (t - i < 0 || k - i < 0) break;
						sum2 += board[t-i][k-i];
					}
					// 왼, 아래
					for (int i=1; i<M; i++) {
						if (k - i < 0 || t + i >= N) break;
						sum2 += board[t+i][k-i];
					}
					// 오, 위
					for (int i=1; i<M; i++) {
						if (t - i < 0 || k + i >= N) break;
						sum2 += board[t-i][k+i];
					}
					// 오, 아래
					for (int i=1; i<M; i++) {
						if (t + i >= N || k + i >= N) break;
						sum2 += board[t+i][k+i];
					}
					answer = Math.max(answer, sum2);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}

}
