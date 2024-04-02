package swea;

import java.io.*;
import java.util.*;

public class Solution2112 {
	private static int answer, D, W, K;
	private static int[] status;
	private static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			answer = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			status = new int[D]; // status[i] : i행의 약품상태 -1 약품x, 0 A약품, 1 B약품
			Arrays.fill(status, -1);
			
			for (int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			recursive(0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static void recursive(int cnt, int row) {
		if (cnt > answer) return;
		if (check()) {
			answer = Math.min(answer, cnt);
			return;
		}
		if (row == D) return;
		
		status[row] = 0;
		recursive(cnt + 1, row + 1);
		status[row] = 1;
		recursive(cnt + 1, row + 1);
		status[row] = -1;
		recursive(cnt, row + 1);
	}
	
	private static boolean check() {
		L: for (int j=0; j<W; j++) {
			for (int i=0; i<D-K+1; i++) {
				int result = 0;
				int expect = status[i] == -1 ? map[i][j] * K : status[i] * K;
				for (int di=0; di<K; di++) {
					result += status[i+di] == -1 ? map[i+di][j] : status[i+di];
				}
				if (result == expect) continue L;
			}
			return false;
		}
		return true;
	}
}
